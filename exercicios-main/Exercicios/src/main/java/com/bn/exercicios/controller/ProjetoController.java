package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Projeto;
import com.bn.exercicios.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/projeto")
public class ProjetoController {

    @Autowired
    private ProjetoService  projetoService;

    @PostMapping
    public Projeto criarProjeto(@RequestBody Projeto projeto){
        return  projetoService.criarProjeto(projeto);
    }

    @GetMapping
    public List<Projeto> buscarTodosProjetos(){
        return  projetoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarProjeto(@PathVariable Long id){
        projetoService.deletarProjeto(id);
    }




}