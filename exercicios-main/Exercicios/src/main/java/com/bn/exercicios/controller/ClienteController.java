package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Cliente;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService  clienteService;

    @PostMapping
    public ResponseEntity <Cliente> criarPessoa(@RequestBody Cliente cliente){
        Cliente request = clienteService.criarCliente(cliente);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(cliente.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Cliente> > findAll(){
        List<Cliente> request = clienteService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Cliente> buscarId(@PathVariable Long id){
        return  clienteService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCliente (@PathVariable Long id){
        clienteService.deletarCliente(id);
        return ResponseEntity.noContent().build();
    }
}