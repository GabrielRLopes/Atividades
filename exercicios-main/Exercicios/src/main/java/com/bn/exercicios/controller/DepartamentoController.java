package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Departamento;
import com.bn.exercicios.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {

    @Autowired
    private DepartamentoService  departamentoService;

    @PostMapping
    public Departamento criarDepartamento(@RequestBody Departamento departamento){
        return  departamentoService.criarDepartamento(departamento);
    }

    @GetMapping
    public List<Departamento> buscarTodosDepartamentos(){
        return  departamentoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarDepartamento(@PathVariable Long id){
        departamentoService.deletarDepartamento(id);
    }
}