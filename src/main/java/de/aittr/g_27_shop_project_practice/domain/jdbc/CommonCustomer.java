package de.aittr.g_27_shop_project_practice.domain.jdbc;

import de.aittr.g_27_shop_project_practice.domain.interfaces.Cart;
import de.aittr.g_27_shop_project_practice.domain.interfaces.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class CommonCustomer implements Customer {
    private int id;
    private boolean isActive;
    private String name;
    private int age;
    private String email;
    private Cart cart;
    private static final Logger logger = LoggerFactory.getLogger(CommonCustomer.class);

    public CommonCustomer() {
        logger.info("Вызван конструктор класса CommonCustomer без параметров");
        this.isActive = true;
    }

    public CommonCustomer(String name, int age, String email) {
        logger.info(String.format("Вызван конструктор класса CommonCustomer с параметрами %s, %d, %s",
                getName(), getAge(), getEmail()));
        this.name = name;
        this.age = age;
        this.email = email;
        this.isActive = true;
    }

    public CommonCustomer(int id, boolean isActive, String name, int age, String email, Cart cart) {
        logger.info("Вызван конструктор класса CommonCustomer со всеми параметрами");
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.age = age;
        this.email = email;
        this.cart = cart;
    }

    public CommonCustomer(int id, boolean isActive, String name, int age, String email) {
        logger.info("Вызван конструктор класса CommonCustomer с параметрами");
        this.id = id;
        this.isActive = isActive;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public int getId() {
        logger.info("Вызван метод getId в классе CommonCustomer");
        return id;
    }

    @Override
    public boolean isActive() {
        logger.info("Вызван метод isActive в классе CommonCustomer");
        return isActive;
    }

    @Override
    public String getName() {
        logger.info("Вызван метод getName в классе CommonCustomer");
        return name;
    }

    @Override
    public void setActive(boolean active) {
        logger.info("Вызван метод setActive в классе CommonCustomer");
        isActive = active;
    }

    @Override
    public void setName(String name) {
        logger.info("Вызван метод setName в классе CommonCustomer");
        this.name = name;
    }

    @Override
    public Cart getCart() {
        logger.info("Вызван метод getCart в классе CommonCustomer");
        return cart;
    }

    @Override
    public void setId(int id) {
        logger.info("Вызван метод setId в классе CommonCustomer");
        this.id = id;
    }

    @Override
    public void setCart(Cart cart) {
        logger.info("Вызван метод setCart в классе CommonCustomer");
        this.cart = cart;
    }

    @Override
    public int getAge() {
        logger.info("Вызван метод getAge в классе CommonCustomer");
        return age;
    }

    @Override
    public void setAge(int age) {
        logger.info("Вызван метод setAge в классе CommonCustomer");
        this.age = age;
    }

    @Override
    public String getEmail() {
        logger.info("Вызван метод getEmail в классе CommonCustomer");
        return email;
    }

    @Override
    public void setEmail(String email) {
        logger.info("Вызван метод setEmail в классе CommonCustomer");
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommonCustomer that = (CommonCustomer) o;
        return id == that.id && isActive == that.isActive && age == that.age && Objects.equals(name, that.name)
                && Objects.equals(email, that.email) && Objects.equals(cart, that.cart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isActive, name, age, email, cart);
    }

    @Override
    public String toString() {
        return "CommonCustomer{" +
                "id=" + id +
                ", isActive=" + isActive +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", cart=" + cart +
                '}';
    }
}