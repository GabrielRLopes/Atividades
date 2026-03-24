package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/livro")
public class LivroController {

    @Autowired
    private LivroService  livroService;

    @PostMapping
    public Livro criarAluno(@RequestBody Livro livro){
        return  livroService.criarLivro(livro);
    }

    @GetMapping
    public List<Livro> buscarTodosLivros(){
        return  livroService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarLivro(@PathVariable Long id){
        livroService.deletarLivro(id);
    }




}