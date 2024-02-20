package de.aittr.g_27_shop_project_practice.services.mapping;

import de.aittr.g_27_shop_project_practice.domain.dto.CartDto;
import de.aittr.g_27_shop_project_practice.domain.dto.ProductDto;
import de.aittr.g_27_shop_project_practice.domain.interfaces.Cart;
import de.aittr.g_27_shop_project_practice.domain.jdbc.CommonCart;
import de.aittr.g_27_shop_project_practice.domain.jdbc.CommonProduct;
import de.aittr.g_27_shop_project_practice.domain.jpa.JpaCart;
import de.aittr.g_27_shop_project_practice.domain.jpa.JpaProduct;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartMappingService {
    private ProductMappingService mappingService;

    public CartMappingService(ProductMappingService mappingService) {
        this.mappingService = mappingService;
    }

    public CartDto mapEntityToDto(Cart cart) {
        int id = cart.getId();
        List<ProductDto> products = cart.getProducts()
                .stream()
                .map(product -> mappingService.mapEntityToDto(product))
                .toList();
        return new CartDto(id, products);
    }

    public JpaCart mapDtoToEntity(CartDto dto) {
        int id = dto.getId();
        List<JpaProduct> products = dto.getProducts()
                .stream()
                .map(productDto -> mappingService.mapDtoToEntity(productDto))
                .toList();
        return new JpaCart(id, products);
    }

    public CommonCart mapDtoToCommonCart(CartDto dto) {
        int id = dto.getId();
        List<CommonProduct> products = dto.getProducts()
                .stream()
                .map(productDto -> mappingService.mapDtoToCommonProduct(productDto))
                .toList();
        return new CommonCart(id, products);
    }
}