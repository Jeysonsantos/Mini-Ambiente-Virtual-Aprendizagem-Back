package com.jeyson.gerenciamentomatricula.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeyson.gerenciamentomatricula.Models.Aluno;
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

    @Transactional
    public List<DisciplinaAluno> findAllByDisciplinaId(Long id_disciplina) {
        return this.disciplinaAlunoRepository.findAllByDisciplinaId(id_disciplina);
    }

    @Transactional
    public List<DisciplinaAluno> findAllByDisciplinaIdAlunoId(Long id_disciplina, Long id_aluno) {
        return this.disciplinaAlunoRepository.findAllByDisciplinaIdAlunoId(id_disciplina, id_aluno);
    }


    @Transactional
    public void deleteDisciplinaAlunoById(Long id_disciplina_aluno) {
        this.disciplinaAlunoRepository.deleteById(id_disciplina_aluno);
    }
}
