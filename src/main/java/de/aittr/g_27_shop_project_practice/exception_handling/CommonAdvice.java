package de.aittr.g_27_shop_project_practice.exception_handling;

import de.aittr.g_27_shop_project_practice.exception_handling.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

// 3 способ - создание класса-адвайса.
// Плюсы - данный адвайс является глобальным обрабобтчиком,
// который ловит исключения, выброшенные в любом месте проекта.
// А также позволяет нам отправлять клиенту любой статус ответа
// и информативное сообщение об ошибке.
@ControllerAdvice
public class CommonAdvice {
    @ExceptionHandler(ThirdTestException.class)
    public ResponseEntity<Response> handleException(ThirdTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.I_AM_A_TEAPOT);
    }

    @ExceptionHandler(FourthTestException.class)
    public ResponseEntity<Response> handleException(FourthTestException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoActiveProductsInDbException.class)
    public ResponseEntity<Response> handleException(NoActiveProductsInDbException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(NoProductWithThisIdException.class)
    public ResponseEntity<Response> handleException(NoProductWithThisIdException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchProductInDbException.class)
    public ResponseEntity<Response> handleException(NoSuchProductInDbException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IncorrectEntryProductToBeUpdatedException.class)
    public ResponseEntity<Response> handleException(IncorrectEntryProductToBeUpdatedException e) {
        Response response = new Response(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleException(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();
        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Response response = Response.builder()
                .message("Ошибка валидации")
                .errors(errors)
                .build();
        return ResponseEntity
                .badRequest()
                .body(response);
    }
}