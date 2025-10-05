package com.example.exercicioModulo3.controllers;

import com.example.exercicioModulo3.dtos.AcaoSustentavelRequest;
import com.example.exercicioModulo3.dtos.AcaoSustentavelResponse;
import com.example.exercicioModulo3.services.AcaoSustentavelService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Valid
@RestController
@RequestMapping("AcaoSustentavel")
@RequiredArgsConstructor
public class Controller {

    public AcaoSustentavelService service = new AcaoSustentavelService();

    @GetMapping
    public List<AcaoSustentavelResponse> getAll(AcaoSustentavelRequest dto){
        return service.FindAll();
    }
    @GetMapping("{id}")
    public AcaoSustentavelResponse getById(@PathVariable long id){
        return service.findById(id);
    }
    @PostMapping
    public AcaoSustentavelResponse register(@RequestBody AcaoSustentavelRequest dto){
        return service.create(dto);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        service.delete(id);
        return ResponseEntity.ok("A ação "+id+" foi deletada com sucesso");
    }



}
