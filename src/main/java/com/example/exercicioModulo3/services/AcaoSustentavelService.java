package com.example.exercicioModulo3.services;

import com.example.exercicioModulo3.dtos.AcaoSustentavelRequest;
import com.example.exercicioModulo3.dtos.AcaoSustentavelResponse;
import com.example.exercicioModulo3.entities.AcaoSustentavel;
import com.example.exercicioModulo3.enums.Categoria;
import com.example.exercicioModulo3.errors.AcaoSustentavelNotFoundException;
import com.example.exercicioModulo3.errors.NotFoundException;
import com.example.exercicioModulo3.mappers.AcaoSustentavelMapper;
import com.example.exercicioModulo3.repositories.AcaoSustentavelRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class AcaoSustentavelService {

    private AcaoSustentavelRepository repository;

    public List<AcaoSustentavelResponse>FindAll() {
        List<AcaoSustentavel> acaoSustentavel = repository.findAll();
        return AcaoSustentavelMapper.getListDto(acaoSustentavel);
    }
    public AcaoSustentavelResponse findById(Long id){
        AcaoSustentavel acaoSustentavel = repository.findById(id).orElseThrow(()-> new AcaoSustentavelNotFoundException(id));
        return AcaoSustentavelMapper.getDto(acaoSustentavel);
    }

    public AcaoSustentavelResponse create(AcaoSustentavelRequest dto){
        AcaoSustentavel acaoSustentavel = new AcaoSustentavel();
        AcaoSustentavelMapper.toEntity(acaoSustentavel, dto);
        repository.save(acaoSustentavel);
        return AcaoSustentavelMapper.getDto(acaoSustentavel);
    }

    public AcaoSustentavelResponse update(Long id, AcaoSustentavelRequest dto) {
        AcaoSustentavel acaoSustentavel = repository.findById(id).orElseThrow(()-> new AcaoSustentavelNotFoundException(id));
        AcaoSustentavelMapper.toEntity(acaoSustentavel, dto);
        repository.save(acaoSustentavel);
        return AcaoSustentavelMapper.getDto(acaoSustentavel);
    }

    public void delete(Long id) {
        AcaoSustentavel acaoSustentavel = repository.findById(id).orElseThrow(()-> new AcaoSustentavelNotFoundException(id));
        repository.deleteById(id);

    }

    public List<AcaoSustentavelResponse> filtro (String categoria) {
       try {
           Categoria categoriaEnum = Categoria.valueOf(categoria.toUpperCase());
           List<AcaoSustentavel> acaoSustentavelLista = repository.findByCategoria(categoriaEnum);
           return AcaoSustentavelMapper.getListDto(acaoSustentavelLista);
       }catch (IllegalArgumentException e){
        throw new IllegalArgumentException("Categoria inválida: " + categoria);
    }

}}


