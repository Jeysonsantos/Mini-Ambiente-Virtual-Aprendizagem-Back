package com.jeyson.gerenciamentomatricula.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Models.Professor;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
    boolean existsByCodigo(String codigo);
}
