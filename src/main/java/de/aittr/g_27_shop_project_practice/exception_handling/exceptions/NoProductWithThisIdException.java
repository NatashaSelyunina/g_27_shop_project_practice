package de.aittr.g_27_shop_project_practice.exception_handling.exceptions;

public class NoProductWithThisIdException extends RuntimeException {
    public NoProductWithThisIdException(String message) {
        super(message);
    }
}