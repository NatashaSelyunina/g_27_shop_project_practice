package de.aittr.g_27_shop_project_practice.domain.jpa;

import de.aittr.g_27_shop_project_practice.domain.interfaces.Product;
import jakarta.persistence.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

@Entity
@Table(name = "product")
public class JpaProduct implements Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    // Минимум 4 буквы, первая большая, остальные маленькие, не было символов, цифр.
    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;
    @Column(name = "is_active")
    private boolean isActive;

    //private static final Logger logger = LoggerFactory.getLogger(JpaProduct.class);

    public JpaProduct() {
        //logger.info("Вызван конструктор без параметров");
    }

    public JpaProduct(int id, String name, double price, boolean isActive) {
        //logger.info("Вызван конструктор с параметрами");
        this.id = id;
        this.name = name;
        this.price = price;
        this.isActive = isActive;
    }

    @Override
    public int getId() {
        //logger.info("Вызван метод getId у продукта");
        return id;
    }

    @Override
    public void setId(int id) {
        //logger.info("Вызван метод setId у продукта");
        this.id = id;
    }

    @Override
    public String getName() {
        //logger.info("Вызван метод getName у продукта");
        return name;
    }

    @Override
    public void setName(String name) {
        //logger.info("Вызван метод setName у продукта");
        this.name = name;
    }

    @Override
    public double getPrice() {
        //logger.info("Вызван метод getPrice у продукта");
        return price;
    }

    @Override
    public void setPrice(double price) {
        //logger.info("Вызван метод setPrice у продукта");
        this.price = price;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JpaProduct that = (JpaProduct) o;
        return id == that.id && Double.compare(price, that.price) == 0 && isActive == that.isActive
                && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, isActive);
    }

    @Override
    public String toString() {
        return "JpaProduct{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isActive=" + isActive +
                '}';
    }
}