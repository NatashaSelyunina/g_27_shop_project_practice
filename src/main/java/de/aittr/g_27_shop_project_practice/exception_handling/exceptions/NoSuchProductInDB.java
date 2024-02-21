package de.aittr.g_27_shop_project_practice.exception_handling.exceptions;

public class NoSuchProductInDB extends RuntimeException {
    public NoSuchProductInDB(String message) {
        super(message);
    }
}