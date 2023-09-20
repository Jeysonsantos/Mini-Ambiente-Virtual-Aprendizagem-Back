package com.jeyson.gerenciamentomatricula.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeyson.gerenciamentomatricula.Models.DisciplinaAluno;

public interface DisciplinaAlunoRepository extends JpaRepository<DisciplinaAluno, Long>{

    @Query("SELECT a FROM DisciplinaAluno a WHERE a.disciplina.id_disciplina = :id_disciplina")
    List<DisciplinaAluno> findAllByDisciplinaId(Long id_disciplina);

    @Query("SELECT a FROM DisciplinaAluno a WHERE a.disciplina.id_disciplina = :id_disciplina AND a.aluno.id_aluno = :id_aluno")
    List<DisciplinaAluno> findAllByDisciplinaIdAlunoId(Long id_disciplina, Long id_aluno);
    
    @Query("SELECT a FROM DisciplinaAluno a WHERE a.aluno.id_aluno = :id_aluno")
    List<DisciplinaAluno> findAllByAlunoId(Long id_aluno);
}
