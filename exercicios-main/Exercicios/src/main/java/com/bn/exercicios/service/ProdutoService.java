package com.bn.exercicios.service;

import com.bn.exercicios.entity.Produto;
import com.bn.exercicios.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto criarProduto(Produto produto){
        return  produtoRepository.save(produto);
    }

    public List<Produto> findAll(){
        return  produtoRepository.findAll();
    }

    public Optional<Produto> buscarid(Long id){
        return  produtoRepository.findById(id);
    }

    public void deletarProduto(Long id){
        produtoRepository.deleteById(id);
    }



}