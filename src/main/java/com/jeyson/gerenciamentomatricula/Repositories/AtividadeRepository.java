package com.jeyson.gerenciamentomatricula.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeyson.gerenciamentomatricula.Models.Atividade;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{
    @Query("SELECT a FROM Atividade a WHERE a.id_postagem = :id_postagem")
    Atividade findByPostagemId(Long id_postagem);
    
}
