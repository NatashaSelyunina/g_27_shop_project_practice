package de.aittr.g_27_shop_project_practice.services.jdbc;

import de.aittr.g_27_shop_project_practice.domain.dto.CustomerDto;
import de.aittr.g_27_shop_project_practice.domain.interfaces.Customer;
import de.aittr.g_27_shop_project_practice.repositories.interfaces.CustomerRepository;
import de.aittr.g_27_shop_project_practice.services.interfaces.CustomerService;
import de.aittr.g_27_shop_project_practice.services.mapping.CustomerMappingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CommonCustomerService implements CustomerService {
    private CustomerRepository repository;
    private CustomerMappingService mappingService;

    public CommonCustomerService(CustomerRepository repository, CustomerMappingService mappingService) {
        this.repository = repository;
        this.mappingService = mappingService;
    }

    @Override
    public CustomerDto save(CustomerDto customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Сохраняемый покупатель не может быть null");
        }

        if (customer.getName() == null || customer.getName().isEmpty()) {
            throw new IllegalArgumentException("Имя сохраняемого покупателя не может быть пустым");
        }

        Customer entity = mappingService.mapDtoToCommonCustomer(customer);
        entity = repository.save(entity);
        return mappingService.mapEntityToDto(entity);
    }

    @Override
    public List<CustomerDto> getAllActiveCustomers() {
        List<Customer> customers = repository.getAll();

        if (customers.isEmpty()) {
            throw new NoSuchElementException("В базе данных нет покупателей");
        }
        return customers.stream().map(x -> mappingService.mapEntityToDto(x)).toList();
    }

    @Override
    public CustomerDto getActiveCustomerById(int id) {
        return null;
    }

    @Override
    public void update(CustomerDto customer) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void deleteByName(String name) {

    }

    @Override
    public void restoreById(int id) {

    }

    @Override
    public int getActiveCustomersCount() {
        return 0;
    }

    @Override
    public double getTotalCartPriceById(int customerId) {
        return 0;
    }

    @Override
    public double getAveragePriceById(int customerId) {
        return 0;
    }

    @Override
    public void addProductToCart(int customerId, int productId) {

    }

    @Override
    public void deleteProductFromCart(int customerId, int productId) {

    }

    @Override
    public void clearCartById(int customerId) {

    }
}