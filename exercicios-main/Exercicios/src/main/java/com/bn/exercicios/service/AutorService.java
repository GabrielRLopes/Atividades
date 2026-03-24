package com.bn.exercicios.service;

import com.bn.exercicios.entity.Autor;
import com.bn.exercicios.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    public Autor criarAutor(Autor autor){
        return  autorRepository.save(autor);
    }

    public List<Autor> findAll(){
        return  autorRepository.findAll();
    }

    public Optional<Autor> buscarid(Long id){
        return  autorRepository.findById(id);
    }

    public void deletarAutor(Long id){
        autorRepository.deleteById(id);
    }



}