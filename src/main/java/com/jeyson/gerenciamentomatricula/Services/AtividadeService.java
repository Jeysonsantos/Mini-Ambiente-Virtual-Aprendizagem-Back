package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeyson.gerenciamentomatricula.Models.Atividade;
import com.jeyson.gerenciamentomatricula.Repositories.AtividadeRepository;


@Service
public class AtividadeService {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Transactional
    public Atividade createAtividade(Atividade atividade) {
        atividade.setId_atividade(null);
        atividade = this.atividadeRepository.save(atividade);
        return atividade;
    }
    
}
