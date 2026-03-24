package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Categoria;
import com.bn.exercicios.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService  categoriaService;

    @PostMapping
    public Categoria criarCategoria(@RequestBody Categoria categoria){
        return  categoriaService.criarCategoria(categoria);
    }

    @GetMapping
    public List<Categoria> buscarTodasCategorias(){
        return  categoriaService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarCategoria(@PathVariable Long id){
        categoriaService.deletarCategoria(id);
    }
}