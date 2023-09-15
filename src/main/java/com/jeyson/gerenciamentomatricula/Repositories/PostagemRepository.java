package com.jeyson.gerenciamentomatricula.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeyson.gerenciamentomatricula.Models.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{

    @Query("SELECT p FROM Postagem p WHERE p.disciplina.id_disciplina = :id_disciplina")
    List<Postagem> findAllByDisciplinaId(@Param("id_disciplina") Long disciplinaId);
    
}
