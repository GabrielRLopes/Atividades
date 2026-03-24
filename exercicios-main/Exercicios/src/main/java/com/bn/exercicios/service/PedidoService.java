package com.bn.exercicios.service;

import com.bn.exercicios.entity.Pedido;
import com.bn.exercicios.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    public Pedido criarPedido(Pedido pedido){
        return  pedidoRepository.save(pedido);
    }

    public List<Pedido> findAll(){
        return  pedidoRepository.findAll();
    }

    public void deletarPedido(Long id){
        pedidoRepository.deleteById(id);
    }



}