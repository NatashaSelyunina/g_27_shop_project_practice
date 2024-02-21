package de.aittr.g_27_shop_project_practice.domain.dto;

import java.util.Objects;

public class CustomerDto {
    private int id;
    private String name;
    private int age;
    private String email;
    private CartDto cartDto;

    public CustomerDto(int id, String name, int age, String email, CartDto cartDto) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name)
                && Objects.equals(email, that.email) && Objects.equals(cartDto, that.cartDto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, email, cartDto);
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", cartDto=" + cartDto +
                '}';
    }
}