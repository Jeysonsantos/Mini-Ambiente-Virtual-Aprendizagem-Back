package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long>{
    
    Professor findByCpf(String cpf);
    Boolean existsByCodigo(String codigo);
    Boolean existsByCpf(String cpf);
    Boolean existsByRg(String rg);
    Boolean existsByTelefone(String telefone);
    Boolean existsByEmail(String email);

}
