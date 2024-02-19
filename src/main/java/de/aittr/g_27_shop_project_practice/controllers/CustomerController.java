package de.aittr.g_27_shop_project_practice.controllers;

import de.aittr.g_27_shop_project_practice.domain.jdbc.CommonCustomer;
import de.aittr.g_27_shop_project_practice.domain.interfaces.Customer;
import de.aittr.g_27_shop_project_practice.services.interfaces.CustomerService;
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
    public Customer save(@RequestBody CommonCustomer customer) {
        return service.save(customer);
    }

    @GetMapping
    public List<Customer> getAll() {
        return service.getAllActiveCustomers();
    }
}