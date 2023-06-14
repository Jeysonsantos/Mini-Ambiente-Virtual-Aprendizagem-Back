package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
    
}
