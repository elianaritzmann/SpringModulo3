package com.example.exercicioModulo3.dtos;

import com.example.exercicioModulo3.enums.Categoria;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

public record AcaoSustentavelRequest(



        @NotBlank
        @Size(max = 50, message = "O titulo deve ter no máximo 50 caracteres")
        String titulo,

        @NotBlank
        @Size (max = 100, message = "A descrição deve ter no máximo 100 caracteres")
        String descricao,

        @NotBlank
        Categoria categoria,

        @PastOrPresent
        LocalDate dataRealizacao,

        @Size(max = 50, message = "O nome do responsável deve ter no máximo 50 caracteres")
        @NotBlank
        String responsavel
) {
}
