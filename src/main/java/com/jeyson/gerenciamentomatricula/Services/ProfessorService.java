package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Repositories.ProfessorRepository;


@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    @Transactional
    public Professor createProfessor(Professor professor) {
        professor.setId_professor(null);
        professor = this.professorRepository.save(professor);
        return professor;
    }
}
