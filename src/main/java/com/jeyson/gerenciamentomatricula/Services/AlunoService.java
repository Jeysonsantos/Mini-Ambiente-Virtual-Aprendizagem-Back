package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Repositories.AlunoRepository;


@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public Aluno getAlunoById(Long alunoId) {
        return null;
    }

    @Transactional
    public Aluno createAluno(Aluno aluno) {
        aluno = this.alunoRepository.save(aluno);
        return aluno;
    }

}
