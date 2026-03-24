package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Pedido;
import com.bn.exercicios.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService  pedidoService;

    @PostMapping
    public Pedido criarPedido(@RequestBody Pedido pedido){
        return  pedidoService.criarPedido(pedido);
    }

    @GetMapping
    public List<Pedido> buscarTodosPedidos(){
        return  pedidoService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deletarPedido(@PathVariable Long id){
        pedidoService.deletarPedido(id);
    }




}