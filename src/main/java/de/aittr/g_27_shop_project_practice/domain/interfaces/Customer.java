package de.aittr.g_27_shop_project_practice.domain.interfaces;

public interface Customer {
    int getId();
    boolean isActive();
    void setActive(boolean isActive);
    String getName();

    void setName(String name);
    Cart getCart();
    void setId(int id);
    void setCart(Cart cart);
}