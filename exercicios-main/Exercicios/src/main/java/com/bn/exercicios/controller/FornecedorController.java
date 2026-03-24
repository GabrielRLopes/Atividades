package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Fornecedor;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorService  fornecedorService;

    @PostMapping
    public ResponseEntity <Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor){
        Fornecedor request = fornecedorService.criarFornecedor(fornecedor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(fornecedor.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Fornecedor> > findAll(){
        List<Fornecedor> request = fornecedorService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Fornecedor> buscarId(@PathVariable Long id){
        return  fornecedorService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarFornecedor (@PathVariable Long id){
        fornecedorService.deletarFornecedor(id);
        return ResponseEntity.noContent().build();
    }
}