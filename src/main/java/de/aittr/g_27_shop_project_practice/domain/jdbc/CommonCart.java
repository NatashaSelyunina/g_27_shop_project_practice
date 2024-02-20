package de.aittr.g_27_shop_project_practice.domain.jdbc;

import de.aittr.g_27_shop_project_practice.domain.interfaces.Cart;
import de.aittr.g_27_shop_project_practice.domain.interfaces.Product;
import de.aittr.g_27_shop_project_practice.domain.jpa.JpaProduct;

import java.util.ArrayList;
import java.util.List;

public class CommonCart implements Cart {
    private int id;
    private List<CommonProduct> products = new ArrayList<>();

    public CommonCart() {
    }

    public CommonCart(int id) {
        this.id = id;
    }

    public CommonCart(int id, List<CommonProduct> products) {
        this.id = id;
        this.products = products;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setProducts(List<Product> products) {
        this.products = products.stream().map(x -> {
            CommonProduct entity = new CommonProduct();
            entity.setId(x.getId());
            entity.setName(x.getName());
            entity.setActive(x.isActive());
            entity.setPrice(x.getPrice());
            return entity;
        }).toList();
    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void deleteProductById(int productId) {
        products.removeIf(x -> x.getId() == productId);
    }

    @Override
    public void clear() {
        products.clear();
    }

    @Override
    public double getTotalPrice() {
        return products.stream()
                .filter(x -> x.isActive())
                .mapToDouble(x -> x.getPrice())
                .sum();
    }

    @Override
    public double getAveragePrice() {
        return products.stream()
                .filter(x -> x.isActive())
                .mapToDouble(x -> x.getPrice())
                .average()
                .orElse(0);
    }
}