package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.entity.Produto;
import com.bn.exercicios.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService  produtoService;

    @PostMapping
    public ResponseEntity <Produto> criarProduto(@RequestBody Produto produto){
        Produto request = produtoService.criarProduto(produto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(produto.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Produto> > findAll(){
        List<Produto> request = produtoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarId(@PathVariable Long id){
        return  produtoService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarProduto (@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }




}