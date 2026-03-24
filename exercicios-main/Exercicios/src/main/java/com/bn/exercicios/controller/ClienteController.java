package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Cliente;
import com.bn.exercicios.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/cliente")
public class ClienteController {

    @Autowired
    private ClienteService  clienteService;

    @PostMapping
    public Cliente criarCliente(@RequestBody Cliente cliente){
        return  clienteService.criarCliente(cliente);
    }

    @GetMapping
    public List<Cliente> buscarTodosClientes(){
        return  clienteService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarCliente(@PathVariable Long id){
        clienteService.deletarCliente(id);
    }
}