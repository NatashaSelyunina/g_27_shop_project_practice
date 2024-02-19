package de.aittr.g_27_shop_project_practice.controllers;

import de.aittr.g_27_shop_project_practice.domain.dto.ProductDto;
import de.aittr.g_27_shop_project_practice.exception_handling.Response;
import de.aittr.g_27_shop_project_practice.exception_handling.exceptions.FirstTestException;
import de.aittr.g_27_shop_project_practice.services.interfaces.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    public ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductDto save(@Valid @RequestBody ProductDto product) {
        return service.save(product);
    }

    @GetMapping
    public List<ProductDto> getAll() {
        return service.getAllActiveProducts();
    }

    @GetMapping("/{id}")
    public ProductDto getById(@PathVariable int id) {
        return service.getActiveProductById(id);
    }

    @PutMapping
    public void update(@RequestBody ProductDto product) {
        service.update(product);
    }

    @GetMapping("/restore/{id}")
    public void restoreById(@PathVariable int id) {
        service.restoreById(id);
    }

    // 1 способ - написание метода-хэндлера в контроллере.
    // Минус - когда требуется одинаковая обработка ошибок,
    // такой хэндлер придется написать в каждом контроллере.
    // Плюс - когда требуется разная обработка ошибок для разных контроллеров,
    // такой способ позволяет настроить точечно разную логику обработки
    // под каждый контроллер в отдельности.
    @ExceptionHandler(FirstTestException.class)
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Response handleException(FirstTestException e) {
        return new Response(e.getMessage());
    }
}