package com.bn.exercicios.service;

import com.bn.exercicios.entity.Categoria;
import com.bn.exercicios.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria criarCategoria(Categoria categoria){
        return  categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll(){
        return  categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarid(Long id){
        return  categoriaRepository.findById(id);
    }

    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }



}