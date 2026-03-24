package com.bn.exercicios.service;

import com.bn.exercicios.entity.Tarefa;
import com.bn.exercicios.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa criarTarefa(Tarefa tarefa){
        return  tarefaRepository.save(tarefa);
    }

    public List<Tarefa> findAll(){
        return  tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarid(Long id){
        return  tarefaRepository.findById(id);
    }

    public void deletarTarefa(Long id){
        tarefaRepository.deleteById(id);
    }
}