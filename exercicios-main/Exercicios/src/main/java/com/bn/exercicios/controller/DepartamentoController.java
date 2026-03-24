package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Departamento;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService  departamentoService;

    @PostMapping
    public ResponseEntity <Departamento> criarDepartamento(@RequestBody Departamento departamento){
        Departamento request = departamentoService.criarDepartamento(departamento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(departamento.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Departamento> > findAll(){
        List<Departamento> request = departamentoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Departamento> buscarId(@PathVariable Long id){
        return  departamentoService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarDepartamento (@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
        return ResponseEntity.noContent().build();
    }
}