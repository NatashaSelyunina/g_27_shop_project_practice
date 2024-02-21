package de.aittr.g_27_shop_project_practice.domain.jpa;

import de.aittr.g_27_shop_project_practice.domain.interfaces.Cart;
import de.aittr.g_27_shop_project_practice.domain.interfaces.Customer;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "customer")
public class JpaCustomer implements Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "is_active")
    private boolean isActive;
    @Column(name = "age")
    private int age;
    @Column(name = "email")
    private String email;
    @OneToOne(mappedBy = "customer")
    private JpaCart cart;

    public JpaCustomer(int id, String name, boolean isActive, int age, String email, JpaCart cart) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.age = age;
        this.email = email;
        this.cart = cart;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isActive() {
        return isActive;
    }

    @Override
    public void setActive(boolean active) {
        isActive = active;
    }

    @Override
    public Cart getCart() {
        return cart;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setCart(Cart cart) {
        JpaCart entity = new JpaCart();
        entity.setId(cart.getId());
        entity.setProducts(cart.getProducts());
        this.cart = entity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaCustomer customer = (JpaCustomer) o;
        return id == customer.id && isActive == customer.isActive && age == customer.age
                && Objects.equals(name, customer.name) && Objects.equals(email, customer.email)
                && Objects.equals(cart, customer.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isActive, age, email, cart);
    }

    @Override
    public String toString() {
        return "JpaCustomer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isActive=" + isActive +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }
}