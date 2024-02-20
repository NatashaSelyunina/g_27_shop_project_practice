package de.aittr.g_27_shop_project_practice.services.mapping;

import de.aittr.g_27_shop_project_practice.domain.dto.CartDto;
import de.aittr.g_27_shop_project_practice.domain.dto.CustomerDto;
import de.aittr.g_27_shop_project_practice.domain.interfaces.Customer;
import de.aittr.g_27_shop_project_practice.domain.jdbc.CommonCart;
import de.aittr.g_27_shop_project_practice.domain.jdbc.CommonCustomer;
import de.aittr.g_27_shop_project_practice.domain.jpa.JpaCart;
import de.aittr.g_27_shop_project_practice.domain.jpa.JpaCustomer;
import org.springframework.stereotype.Service;

@Service
public class CustomerMappingService {

    private CartMappingService mappingService;

    public CustomerMappingService(CartMappingService mappingService) {
        this.mappingService = mappingService;
    }

    public CustomerDto mapEntityToDto(Customer customer) {
        int id = customer.getId();
        String name = customer.getName();
        CartDto cartDto = mappingService.mapEntityToDto(customer.getCart());
        return new CustomerDto(id, name, cartDto);
    }

    public JpaCustomer mapDtoToEntity(CustomerDto dto) {
        int id = dto.getId();
        String name = dto.getName();
        JpaCart jpaCart = mappingService.mapDtoToEntity(dto.getCartDto());
        return new JpaCustomer(id, name, true, jpaCart);
    }

    public CommonCustomer mapDtoToCommonCustomer(CustomerDto dto) {
        int id = dto.getId();
        String name = dto.getName();
        CommonCart commonCart = mappingService.mapDtoToCommonCart(dto.getCartDto());
        return new CommonCustomer(id, true, name, commonCart);
    }
}