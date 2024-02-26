package de.aittr.g_27_shop_project_practice.domain.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.util.Objects;

public class ProductDto {
    private int id;
    @Pattern(regexp = "[A-Z][a-z]{3,}", message =
            "Наименование продукта должно начинаться с большой буквы и содержать как минимум 4 буквы")
    private String name;
    @Max(value = 90000, message = "Цена продукта не должна быть выше 90000")
    @Min(value = 10, message = "Цена продукта не должна быть ниже 10")
    private double price;

    public ProductDto(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDto that = (ProductDto) o;
        return id == that.id && Double.compare(price, that.price) == 0 && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }

    @Override
    public String toString() {
        return "ProductDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}