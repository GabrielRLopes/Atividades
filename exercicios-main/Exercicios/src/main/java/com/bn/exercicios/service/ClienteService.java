package com.bn.exercicios.service;

import com.bn.exercicios.entity.Cliente;
import com.bn.exercicios.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente criarCliente(Cliente cliente){
        return  clienteRepository.save(cliente);
    }

    public List<Cliente> findAll(){
        return  clienteRepository.findAll();
    }

    public Optional<Cliente> buscarid(Long id){
        return  clienteRepository.findById(id);
    }

    public void deletarCliente(Long id){
        clienteRepository.deleteById(id);
    }



}