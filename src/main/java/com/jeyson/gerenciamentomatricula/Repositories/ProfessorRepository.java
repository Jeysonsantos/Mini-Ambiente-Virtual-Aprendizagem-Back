package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
}
