package com.jeyson.gerenciamentomatricula.Services.AlunoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Repositories.AlunoRepository;



@Service    
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    public String getEmailById(Long id) {
        Aluno aluno = alunoRepository.findById(id).orElse(null);

        if (aluno != null) {
            return aluno.getEmail();
        } else {
            return null;
        }
    }

    
}
