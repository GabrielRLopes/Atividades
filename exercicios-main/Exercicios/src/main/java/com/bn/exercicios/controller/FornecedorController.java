package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Fornecedor;
import com.bn.exercicios.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService  fornecedorService;

    @PostMapping
    public Fornecedor criarFornecedor(@RequestBody Fornecedor fornecedor){
        return  fornecedorService.criarFornecedor(fornecedor);
    }

    @GetMapping
    public List<Fornecedor> buscarTodosFornecedores(){
        return  fornecedorService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarFornecedor(@PathVariable Long id){
        fornecedorService.deletarFornecedor(id);
    }
}