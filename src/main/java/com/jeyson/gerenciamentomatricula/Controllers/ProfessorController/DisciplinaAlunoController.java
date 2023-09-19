package com.jeyson.gerenciamentomatricula.Controllers.ProfessorController;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Models.DisciplinaAluno;
import com.jeyson.gerenciamentomatricula.Services.DisciplinaAlunoService;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminDisciplinaService;

import jakarta.validation.Valid;



@RestController
@Validated
@RequestMapping("/professor/disciplina")
@CrossOrigin(origins = "http://localhost:4200")
public class DisciplinaAlunoController {

    @Autowired
    private DisciplinaAlunoService disciplinaAlunoService;

    @Autowired
    private AdminDisciplinaService disciplinaService;

    @PostMapping("/{id_disciplina}/vincularAlunos")
    public ResponseEntity<List<DisciplinaAluno>> vincularAlunos(@RequestBody Aluno[] alunos, @PathVariable Long id_disciplina) {
        List<DisciplinaAluno> disciplinaAlunos = new ArrayList<DisciplinaAluno>();
        for (Aluno aluno : alunos) {
            DisciplinaAluno disciplinaAluno = new DisciplinaAluno();
            disciplinaAluno.setAluno(aluno);
            Disciplina disciplina = disciplinaService.getDisciplinaById(id_disciplina);
            disciplinaAluno.setDisciplina(disciplina);
            disciplinaAlunoService.createDisciplinaAluno(disciplinaAluno);
            disciplinaAlunos.add(disciplinaAluno);
        }
        return ResponseEntity.ok(disciplinaAlunos);
    }

    @GetMapping("/{id_disciplina}/alunos")
    public ResponseEntity<List<Aluno>> getAlunos(@PathVariable Long id_disciplina) {
        List<Aluno> alunos = new ArrayList<Aluno>();
        List<DisciplinaAluno> disciplinaAlunos = disciplinaAlunoService.findAllByDisciplinaId(id_disciplina);
        for (DisciplinaAluno disciplinaAluno : disciplinaAlunos) {
            alunos.add(disciplinaAluno.getAluno());
        }
        return ResponseEntity.ok(alunos);
    }

    @DeleteMapping("/{id_disciplina}/desvincularAluno/{id_aluno}")
    public ResponseEntity<Boolean> desvincularAluno(@PathVariable Long id_disciplina, @PathVariable Long id_aluno) {
        List<DisciplinaAluno> disciplinaAlunos = disciplinaAlunoService.findAllByDisciplinaIdAlunoId(id_disciplina, id_aluno);
        if(disciplinaAlunos.size() > 0) {
            for (DisciplinaAluno disciplinaAluno : disciplinaAlunos) {
                disciplinaAlunoService.deleteDisciplinaAlunoById(disciplinaAluno.getId_disciplina_aluno());
            }
            return ResponseEntity.ok(true);
        }
        return ResponseEntity.ok(false);
    }
    
    
}
