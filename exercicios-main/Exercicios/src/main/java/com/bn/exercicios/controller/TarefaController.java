package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Tarefa;
import com.bn.exercicios.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService  tarefaService;

    @PostMapping
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa){
        return  tarefaService.criarTarefa(tarefa);
    }

    @GetMapping
    public List<Tarefa> buscarTodasTarefas(){
        return  tarefaService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarTarefa(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }




}