package com.jeyson.gerenciamentomatricula.Repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeyson.gerenciamentomatricula.Models.Disciplina;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    
    boolean existsByCodigo(String codigo);
    @Query("SELECT d FROM Disciplina d WHERE d.id_professor.id_professor = :professorId")
    List<Disciplina> findAllByProfessorId(@Param("professorId") Long professorId);
}
