package com.bn.exercicios.service;

import com.bn.exercicios.entity.Fornecedor;
import com.bn.exercicios.repository.FornecedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FornecedorService {

    @Autowired
    private FornecedorRepository fornecedorRepository;

    public Fornecedor criarFornecedor(Fornecedor fornecedor){
        return  fornecedorRepository.save(fornecedor);
    }

    public List<Fornecedor> findAll(){
        return  fornecedorRepository.findAll();
    }

    public Optional<Fornecedor> buscarid(Long id){
        return  fornecedorRepository.findById(id);
    }

    public void deletarFornecedor(Long id){
        fornecedorRepository.deleteById(id);
    }



}