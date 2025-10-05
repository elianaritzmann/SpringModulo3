package com.example.exercicioModulo3.errors;

public class AcaoSustentavelNotFoundException extends NotFoundException {
    public AcaoSustentavelNotFoundException(Long id) {
        super("Ação sustentavel", id);
    }
}
