package com.example.exercicioModulo3.errors;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String message, Long id) {
        super(message);
    }
}
