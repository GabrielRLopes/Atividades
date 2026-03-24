package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Categoria;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService  categoriaService;

    @PostMapping
    public ResponseEntity <Categoria> criarCategoria(@RequestBody Categoria categoria){
        Categoria request = categoriaService.criarCategoria(categoria);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(categoria.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Categoria> > findAll(){
        List<Categoria> request = categoriaService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Categoria> buscarId(@PathVariable Long id){
        return  categoriaService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCategoria (@PathVariable Long id){
        categoriaService.deletarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}