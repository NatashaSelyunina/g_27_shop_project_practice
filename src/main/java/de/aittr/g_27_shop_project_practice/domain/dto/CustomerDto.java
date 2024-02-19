package de.aittr.g_27_shop_project_practice.domain.dto;

import java.util.Objects;

public class CustomerDto {
    private int id;
    private String name;
    private CartDto cartDto;

    public CustomerDto(int id, String name, CartDto cartDto) {
        this.id = id;
        this.name = name;
        this.cartDto = cartDto;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CartDto getCartDto() {
        return cartDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return id == that.id && Objects.equals(name, that.name) && Objects.equals(cartDto, that.cartDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cartDto);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cartDto=" + cartDto +
                '}';
    }
}