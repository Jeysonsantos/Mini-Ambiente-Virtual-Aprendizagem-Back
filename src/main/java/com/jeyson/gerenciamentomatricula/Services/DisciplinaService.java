package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Repositories.DisciplinaRepository;


@Service
public class DisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Transactional
    public Disciplina createDisciplina(Disciplina disciplina) {
        disciplina.setId_disciplina(null);
        disciplina = this.disciplinaRepository.save(disciplina);
        return disciplina;
    }
    
}
