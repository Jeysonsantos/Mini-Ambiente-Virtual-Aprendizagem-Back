package com.jeyson.gerenciamentomatricula.Services.AdminService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Repositories.DisciplinaRepository;


@Service
public class AdminDisciplinaService {
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @Transactional
    public Disciplina createDisciplina(Disciplina disciplina) {
        disciplina.setId_disciplina(null);
        disciplina = this.disciplinaRepository.save(disciplina);
        return disciplina;
    }
    
    @Transactional
    public Disciplina updateDisciplina(Disciplina disciplina) {
        disciplina = this.disciplinaRepository.save(disciplina);
        return disciplina;
    }
    
    @Transactional
    public void deleteDisciplinaById(Long id) {
        this.disciplinaRepository.deleteById(id);

    }
    
    public List<Disciplina> getAllDisciplinas() {
        return this.disciplinaRepository.findAll();
    }

    public Boolean checkCodigoExists(String codigo) {
        return this.disciplinaRepository.existsByCodigo(codigo);
    }

    public List<Disciplina> findAllByProfessorId(Long professorId) {
        return disciplinaRepository.findAllByProfessorId(professorId);
    }

    public Disciplina findDisciplinaById(Long id) {
        return disciplinaRepository.findById(id).orElse(null);
    }

}
