package de.aittr.g_27_shop_project_practice.exception_handling.exceptions;

public class NoProductWithThisId extends RuntimeException {
    public NoProductWithThisId(String message) {
        super(message);
    }
}