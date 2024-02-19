package de.aittr.g_27_shop_project_practice.exception_handling.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// 2 способ - простановка аннотации на самом классе исключения.
// Минус - не позволяет отправить клиенту информативное сообщение.
// Плюс - это глобальный обработчик и реагирует на исключения,
// выброленные в любом классе проекта.
@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
public class SecondTestException extends RuntimeException {
    public SecondTestException(String message) {
        super(message);
    }
}