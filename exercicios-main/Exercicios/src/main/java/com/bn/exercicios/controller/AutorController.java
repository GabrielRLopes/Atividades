package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/autor")
public class AutorController {

    @Autowired
    private AutorService  autorService;

    @PostMapping
    public ResponseEntity <Autor> criarPessoa(@RequestBody Autor autor){
        Autor request = autorService.criarAutor(autor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(autor.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Autor> > findAll(){
        List<Autor> request = autorService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Autor> buscarId(@PathVariable Long id){
        return  autorService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarAutor (@PathVariable Long id){
        autorService.deletarAutor(id);
        return ResponseEntity.noContent().build();
    }




}