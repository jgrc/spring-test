package com.example.user.infrastructure.io.controller;

import com.example.shared.domain.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public HashMap<String, String> handlerNotFoundException(NotFoundException exception) {
        return response(exception.getLocalizedMessage());
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public HashMap<String, String> handlerIllegalArgumentException(IllegalArgumentException exception) {
        return response(exception.getLocalizedMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public HashMap<String, String> handlerException(Exception exception) {
        return response(exception.getLocalizedMessage());
    }

    private HashMap<String, String> response(String error) {
        HashMap<String, String> response = new HashMap<>();
        response.put("error", error);

        return response;
    }
}