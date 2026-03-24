package com.bn.exercicios.service;

import com.bn.exercicios.entity.Projeto;
import com.bn.exercicios.repository.ProjetoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    public Projeto criarProjeto(Projeto projeto){
        return  projetoRepository.save(projeto);
    }

    public List<Projeto> findAll(){
        return  projetoRepository.findAll();
    }

    public void deletarProjeto(Long id){
        projetoRepository.deleteById(id);
    }
}