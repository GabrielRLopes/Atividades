package com.bn.exercicios.service;

import com.bn.exercicios.entity.Departamento;
import com.bn.exercicios.repository.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento criarDepartamento(Departamento departamento){
        return  departamentoRepository.save(departamento);
    }

    public List<Departamento> findAll(){
        return  departamentoRepository.findAll();
    }

    public Optional<Departamento> buscarid(Long id){
        return  departamentoRepository.findById(id);
    }

    public void deletarDepartamento(Long id){
        departamentoRepository.deleteById(id);
    }



}