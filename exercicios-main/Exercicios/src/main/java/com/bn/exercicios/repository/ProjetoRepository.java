package com.bn.exercicios.repository;

import com.bn.exercicios.entity.Projeto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
}