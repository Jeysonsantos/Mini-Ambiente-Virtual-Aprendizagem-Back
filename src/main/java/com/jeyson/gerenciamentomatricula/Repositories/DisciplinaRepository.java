package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
    boolean existsByCodigo(String codigo);
}
