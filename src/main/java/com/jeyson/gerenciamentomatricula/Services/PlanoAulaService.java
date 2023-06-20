package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.PlanoAula;
import com.jeyson.gerenciamentomatricula.Repositories.PlanoAulaRepository;

@Service
public class PlanoAulaService {
    
    @Autowired
    private PlanoAulaRepository planoAulaRepository;

    @Transactional
    public PlanoAula createPlanoAula(PlanoAula planoAula) {
        planoAula.setId_plano_aula(null);
        planoAula = this.planoAulaRepository.save(planoAula);
        return planoAula;
    }
}
