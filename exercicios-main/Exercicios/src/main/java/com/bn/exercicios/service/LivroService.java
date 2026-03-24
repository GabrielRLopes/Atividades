package com.bn.exercicios.service;

import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro criarLivro(Livro livro){
        return  livroRepository.save(livro);
    }

    public List<Livro> findAll(){
        return  livroRepository.findAll();
    }

    public Optional<Livro> buscarid(Long id){
        return  livroRepository.findById(id);
    }

    public void deletarLivro(Long id){
        livroRepository.deleteById(id);
    }



}