package de.aittr.g_27_shop_project_practice.exception_handling.exceptions;

import org.springframework.http.HttpStatus;

public class NoProductWithThisIdException extends RuntimeException {
    private HttpStatus status;

    public NoProductWithThisIdException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }
}