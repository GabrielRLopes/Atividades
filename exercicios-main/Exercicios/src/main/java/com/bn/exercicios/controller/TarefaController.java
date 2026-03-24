package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.entity.Tarefa;
import com.bn.exercicios.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService  tarefaService;

    @PostMapping
    public ResponseEntity <Tarefa> criarTarefa(@RequestBody Tarefa tarefa){
        Tarefa request = tarefaService.criarTarefa(tarefa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(tarefa.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Tarefa> > findAll(){
        List<Tarefa> request = tarefaService.findAll();
        return ResponseEntity.ok().body(request);
    }
    @GetMapping("/{id}")
    public Optional<Tarefa> buscarId(@PathVariable Long id){
        return  tarefaService.buscarid(id);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarTarefa (@PathVariable Long id){
        tarefaService.deletarTarefa(id);
        return ResponseEntity.noContent().build();
    }




}