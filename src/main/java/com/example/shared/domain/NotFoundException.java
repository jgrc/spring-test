package com.example.shared.domain;

abstract public class NotFoundException extends RuntimeException {
    public NotFoundException(String message) {
        super(message);
    }
}
