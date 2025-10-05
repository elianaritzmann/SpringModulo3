package com.example.exercicioModulo3.entities;

import com.example.exercicioModulo3.enums.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class AcaoSustentavel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column (name = "titulo", nullable = false, length = 50)
    private String titulo;

    @Column (name = "descricao", nullable = false, length = 100)
    private String descricao;

    @Column (nullable = false)
    private Categoria categoria;

    @Column (nullable = false)
    private LocalDate dataRealizacao;

    @Column (name = "responsavel", nullable = false, length = 100)
    private String responsavel;
}
