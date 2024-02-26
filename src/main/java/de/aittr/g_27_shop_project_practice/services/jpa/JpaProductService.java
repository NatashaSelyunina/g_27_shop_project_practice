package de.aittr.g_27_shop_project_practice.services.jpa;

import de.aittr.g_27_shop_project_practice.domain.dto.ProductDto;
import de.aittr.g_27_shop_project_practice.domain.jpa.JpaProduct;
import de.aittr.g_27_shop_project_practice.exception_handling.exceptions.*;
import de.aittr.g_27_shop_project_practice.repositories.jpa.JpaProductRepository;
import de.aittr.g_27_shop_project_practice.services.interfaces.ProductService;
import de.aittr.g_27_shop_project_practice.services.mapping.ProductMappingService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JpaProductService implements ProductService {
    private JpaProductRepository repository;
    private ProductMappingService mappingService;
    //private Logger logger = LogManager.getLogger(JpaProductService.class);
    private Logger logger = LoggerFactory.getLogger(JpaProductService.class);

    public JpaProductService(JpaProductRepository repository, ProductMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    @Override
    public ProductDto save(ProductDto product) {
        try {
            JpaProduct entity = mappingService.mapDtoToEntity(product);
            entity.setId(0);
            entity = repository.save(entity);
            return mappingService.mapEntityToDto(entity);
        } catch (Exception e) {
            throw new FourthTestException(e.getMessage());
        }
    }

    @Override
    public List<ProductDto> getAllActiveProducts() {
//        Task task = new Task("Method getAllActiveProducts called");
//        ScheduleExecutor.scheduleTaskExecution(task);
        List<ProductDto> products = repository.findAll()
                .stream()
                .filter(x -> x.isActive())
                .map(x -> mappingService.mapEntityToDto(x))
                .toList();

        if (!products.isEmpty()) {
            return products;
        }

        throw new NoActiveProductsInDbException();
    }

    @Override
    public ProductDto getActiveProductById(int id) {
//        logger.log(Level.INFO, String.format("Запрошен продукт с ИД %d.", id));
//        logger.log(Level.WARN, String.format("Запрошен продукт с ИД %d.", id));
//        logger.log(Level.ERROR, String.format("Запрошен продукт с ИД %d.", id));

//        logger.info(String.format("Запрошен продукт с ИД %d.", id));
//        logger.warn(String.format("Запрошен продукт с ИД %d.", id));
//        logger.error(String.format("Запрошен продукт с ИД %d.", id));

        JpaProduct product = repository.findById(id).orElse(null);
        if (product != null && product.isActive()) {
            return mappingService.mapEntityToDto(product);
        }

        throw new ThirdTestException("Продукт с указанным ИД отсутствует в базе данных.");
    }

    @Override
    public void update(ProductDto product) {
        try {
            JpaProduct entity = mappingService.mapDtoToEntity(product);
            repository.save(entity);
        } catch (Exception e) {
            throw new IncorrectEntryProductToBeUpdatedException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        JpaProduct product = repository.findById(id).orElse(null);
        if (product != null) {
            repository.deleteById(id);
            return;
        }

        throw new NoProductWithThisIdException("Продукта под таким id нет в базе данных, удалить не получится",
                HttpStatus.BAD_REQUEST);
    }

    @Override
    @Transactional
    public void deleteByName(String name) {
        boolean exists = repository.existsByName(name);
        if (!exists) {
            throw new NoSuchProductInDbException(String.format("Продукт с именем %s отсутствует в базе данных", name));
        }

        repository.deleteByName(name);
    }

    @Override
    @Transactional
    public void restoreById(int id) {
        JpaProduct product = repository.findById(id).orElse(null);

        if (product != null) {
            product.setActive(true);
            return;
        }

        throw new NoProductWithThisIdException("Продукта под таким id нет в базе данных, восстановить не получится",
                HttpStatus.BAD_REQUEST);
    }

    @Override
    public int getActiveProductsCount() {
        return getAllActiveProducts().size();
    }

    @Override
    public double getActiveProductsTotalCost() {
         double totalPrice = repository.findAll()
                .stream()
                .filter(x -> x.isActive())
                .mapToDouble(x -> x.getPrice())
                .sum();
         return totalPrice;
    }

    @Override
    public double getActiveProductsAveragePrice() {
        double averagePrice = repository.findAll()
                .stream()
                .filter(x -> x.isActive())
                .mapToDouble(x -> x.getPrice())
                .average()
                .orElse(0);
        return averagePrice;
    }

    public String getNameLastProduct() {
        return repository.getNameLastProduct();
    }
}