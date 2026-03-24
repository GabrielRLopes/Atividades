package com.bn.exercicios.controller;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.entity.Pedido;
import com.bn.exercicios.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService  pedidoService;
    @PostMapping
    public ResponseEntity <Pedido> criarPedido(@RequestBody Pedido pedido){
        Pedido request = pedidoService.criarPedido(pedido);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(pedido.getId())
                .toUri();
        return  ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<Pedido> > findAll(){
        List<Pedido> request = pedidoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<Pedido> buscarId(@PathVariable Long id){
        return  pedidoService.buscarid(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarPedido (@PathVariable Long id){
        pedidoService.deletarPedido(id);
        return ResponseEntity.noContent().build();
    }




}