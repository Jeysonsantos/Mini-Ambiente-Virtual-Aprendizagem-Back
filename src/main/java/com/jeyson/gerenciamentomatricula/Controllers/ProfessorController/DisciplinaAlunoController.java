package com.jeyson.gerenciamentomatricula.Controllers.ProfessorController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeyson.gerenciamentomatricula.Models.DisciplinaAluno;
import com.jeyson.gerenciamentomatricula.Services.DisciplinaAlunoService;

import jakarta.validation.Valid;



@RestController
@Validated
@RequestMapping("/disciplinaaluno")
@CrossOrigin(origins = "http://localhost:4200")
public class DisciplinaAlunoController {

    @Autowired
    private DisciplinaAlunoService disciplinaAlunoService;

    @PostMapping("/create")
    @Validated(DisciplinaAluno.CreateDisciplinaAluno.class)
    public ResponseEntity<DisciplinaAluno> createDisciplinaAluno(@Valid @RequestBody DisciplinaAluno disciplinaAluno) {
        DisciplinaAluno disciplinaAlunoCriada = disciplinaAlunoService.createDisciplinaAluno(disciplinaAluno);
        return ResponseEntity.ok(disciplinaAlunoCriada);
    }
    
    
}
