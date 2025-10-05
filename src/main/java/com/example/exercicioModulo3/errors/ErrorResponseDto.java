package com.example.exercicioModulo3.errors;


public record ErrorResponseDto(

        String code,
        String mensagem,
        String name) {
}
