package de.aittr.g_27_shop_project_practice.controllers;

import de.aittr.g_27_shop_project_practice.domain.dto.CustomerDto;
import de.aittr.g_27_shop_project_practice.services.interfaces.CustomerService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    public CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @PostMapping
    public CustomerDto save(@Valid @RequestBody CustomerDto customer) {
        return service.save(customer);
    }

    @GetMapping
    public List<CustomerDto> getAll() {
        return service.getAllActiveCustomers();
    }
}