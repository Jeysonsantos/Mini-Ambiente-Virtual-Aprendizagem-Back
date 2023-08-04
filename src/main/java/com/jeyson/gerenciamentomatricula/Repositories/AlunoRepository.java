package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{

    Aluno findByCpf(String cpf);
    Boolean existsByMatricula(String matricula);
    Boolean existsByCpf(String cpf);
    Boolean existsByRg(String rg);
    Boolean existsByTelefone(String telefone);
    Boolean existsByEmail(String email);

}
