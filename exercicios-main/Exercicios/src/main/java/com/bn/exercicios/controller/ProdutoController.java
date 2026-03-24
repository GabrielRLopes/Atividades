package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Produto;
import com.bn.exercicios.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService  produtoService;

    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto){
        return  produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<Produto> buscarTodosProdutos(){
        return  produtoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }




}