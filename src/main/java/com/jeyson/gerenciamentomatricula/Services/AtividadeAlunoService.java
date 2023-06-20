package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.AtividadeAluno;
import com.jeyson.gerenciamentomatricula.Repositories.AtividadeAlunoRepository;

@Service
public class AtividadeAlunoService {
    
    @Autowired
    private AtividadeAlunoRepository atividadeAlunoRepository;

    @Transactional
    public AtividadeAluno createAtividadeAluno(AtividadeAluno atividadeAluno) {
        atividadeAluno.setId_atividade_aluno(null);
        atividadeAluno = this.atividadeAlunoRepository.save(atividadeAluno);
        return atividadeAluno;
    }
}
