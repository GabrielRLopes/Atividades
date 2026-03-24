package com.bn.exercicios.service;

import com.bn.exercicios.entity.Categoria;
import com.bn.exercicios.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria categoriaAutor(Categoria categoria){
        return  categoriaRepository.save(categoria);
    }

    public List<Categoria> findAll(){
        return  categoriaRepository.findAll();
    }

    public void deletarCategoria(Long id){
        categoriaRepository.deleteById(id);
    }



}