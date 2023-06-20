package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.FrequenciaAluno;
import com.jeyson.gerenciamentomatricula.Repositories.FrequenciaAlunoRepository;

@Service
public class FrequenciaAlunoService {

    @Autowired
    private FrequenciaAlunoRepository FrequenciaAlunoRepository;

    @Transactional
    public FrequenciaAluno createFrequenciaAluno(FrequenciaAluno frequenciaAluno) {
        frequenciaAluno.setId_frequencia_aluno(null);
        frequenciaAluno = this.FrequenciaAlunoRepository.save(frequenciaAluno);
        return frequenciaAluno;
    }
}
