package com.bn.exercicios.service;

import com.bn.exercicios.entity.Livro;
import com.bn.exercicios.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository alunoRepository;

    public Livro criarLivro(Livro livro){
        return  alunoRepository.save(livro);
    }

    public List<Livro> findAll(){
        return  alunoRepository.findAll();
    }

    public void deletarLivro(Long id){
        alunoRepository.deleteById(id);
    }



}