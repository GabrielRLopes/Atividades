package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/autor")
public class AutorController {

    @Autowired
    private AutorService  autorService;

    @PostMapping
    public Autor criarAutor(@RequestBody Autor autor){
        return  autorService.criarAutor(autor);
    }

    @GetMapping
    public List<Autor> buscarTodosAutores(){
        return  autorService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarAutor(@PathVariable Long id){
        autorService.deletarAutor(id);
    }




}