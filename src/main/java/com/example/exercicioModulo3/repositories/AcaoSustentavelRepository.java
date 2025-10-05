package com.example.exercicioModulo3.repositories;

import com.example.exercicioModulo3.entities.AcaoSustentavel;
import com.example.exercicioModulo3.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AcaoSustentavelRepository extends JpaRepository<AcaoSustentavel,Long> {
    List<AcaoSustentavel> findByCategoria(Categoria categoria);
}
