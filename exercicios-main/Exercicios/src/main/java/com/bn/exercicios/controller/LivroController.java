package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService  livroService;

    @PostMapping
    public ResponseEntity <Livro> criarLivro(@RequestBody Livro livro){
        Livro request = livroService.criarLivro(livro);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(livro.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Livro> > findAll(){
        List<Livro> request = livroService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Livro> buscarId(@PathVariable Long id){
        return  livroService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarLivro (@PathVariable Long id){
        livroService.deletarLivro(id);
        return ResponseEntity.noContent().build();
    }




}