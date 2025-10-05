package com.example.exercicioModulo3.mappers;

import com.example.exercicioModulo3.dtos.AcaoSustentavelRequest;
import com.example.exercicioModulo3.dtos.AcaoSustentavelResponse;
import com.example.exercicioModulo3.entities.AcaoSustentavel;

import java.util.List;

public class AcaoSustentavelMapper {

    public static AcaoSustentavelResponse getDto(AcaoSustentavel acaoSustentavel){
        return new AcaoSustentavelResponse(
                acaoSustentavel.getId(),
                acaoSustentavel.getTitulo(),
                acaoSustentavel.getDescricao(),
                acaoSustentavel.getCategoria(),
                acaoSustentavel.getDataRealizacao(),
                acaoSustentavel.getResponsavel()
        );
    }

 public static List<AcaoSustentavelResponse> getListDto(List<AcaoSustentavel> acaoSustentavel){
        return acaoSustentavel.stream().map(AcaoSustentavelMapper::getDto).toList();
 }
 public static AcaoSustentavel toEntity(AcaoSustentavel acaoSustentavel,AcaoSustentavelRequest dto){
     if(dto.titulo()==null || dto.titulo().isEmpty()  ){
         throw new IllegalArgumentException("O campo 'Titulo' não pode estar vazio");
     }
     acaoSustentavel.setTitulo(dto.titulo());

     if(dto.descricao()==null || dto.descricao().isEmpty()){
         throw new IllegalArgumentException("O campo 'descrição' não pode estar vazio");
     }acaoSustentavel.setDescricao(dto.descricao());

     if(dto.categoria()==null){
         throw new IllegalArgumentException("O campo 'categoria' não pode estar vazio");
     }acaoSustentavel.setCategoria(dto.categoria());

     if (dto.dataRealizacao()==null){
         throw new IllegalArgumentException("O campo 'data de realização' não pode estar vazio");
     }
     acaoSustentavel.setDataRealizacao(dto.dataRealizacao());

     if (dto.responsavel()==null){
         throw new IllegalArgumentException("O campo'Responsavel' não pode estar vazio");
     }
     acaoSustentavel.setDataRealizacao(dto.dataRealizacao());
    return acaoSustentavel;
}}
