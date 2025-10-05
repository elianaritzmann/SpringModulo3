package com.example.exercicioModulo3.services;

import com.example.exercicioModulo3.dtos.AcaoSustentavelRequest;
import com.example.exercicioModulo3.dtos.AcaoSustentavelResponse;
import com.example.exercicioModulo3.entities.AcaoSustentavel;
import com.example.exercicioModulo3.mappers.AcaoSustentavelMapper;
import com.example.exercicioModulo3.repositories.AcaoSustentavelRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

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
    }}
