package com.example.exercicioModulo3.dtos;

import com.example.exercicioModulo3.enums.Categoria;

import java.time.LocalDate;

public record AcaoSustentavelResponse(
        Long id,
        String titulo,
        String descricao,
        Categoria categoria,
        LocalDate dataRealizacao,
        String responsavel
) {
}
