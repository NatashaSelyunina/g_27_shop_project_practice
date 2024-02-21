package de.aittr.g_27_shop_project_practice.exception_handling.exceptions;

public class NoSuchProductInDbException extends RuntimeException {
    public NoSuchProductInDbException(String message) {
        super(message);
    }
}