package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeyson.gerenciamentomatricula.Models.DisciplinaAluno;
import com.jeyson.gerenciamentomatricula.Repositories.DisciplinaAlunoRepository;

import jakarta.transaction.Transactional;

@Service
public class DisciplinaAlunoService {

    @Autowired
    private DisciplinaAlunoRepository disciplinaAlunoRepository;

    @Transactional
    public DisciplinaAluno createDisciplinaAluno(DisciplinaAluno disciplinaAluno) {
        disciplinaAluno.setId_disciplina_aluno(null);
        disciplinaAluno = this.disciplinaAlunoRepository.save(disciplinaAluno);
        return disciplinaAluno;
    }

}
