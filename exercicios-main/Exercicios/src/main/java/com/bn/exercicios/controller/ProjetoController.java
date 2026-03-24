package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.entity.Projeto;
import com.bn.exercicios.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService  projetoService;

    @PostMapping
    public ResponseEntity <Projeto> criarProjeto(@RequestBody Projeto projeto){
        Projeto request = projetoService.criarProjeto(projeto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(projeto.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Projeto> > findAll(){
        List<Projeto> request = projetoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Projeto> buscarId(@PathVariable Long id){
        return  projetoService.buscarid(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProjeto (@PathVariable Long id){
        projetoService.deletarProjeto(id);
        return ResponseEntity.noContent().build();
    }




}