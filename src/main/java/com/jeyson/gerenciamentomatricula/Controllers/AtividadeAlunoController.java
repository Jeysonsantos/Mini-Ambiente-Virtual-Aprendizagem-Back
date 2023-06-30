package com.jeyson.gerenciamentomatricula.Controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeyson.gerenciamentomatricula.Models.AtividadeAluno;
import com.jeyson.gerenciamentomatricula.Services.AtividadeAlunoService;

import jakarta.validation.Valid;


@RestController
@Validated
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/atividadealuno")
public class AtividadeAlunoController {

    @Autowired
    private AtividadeAlunoService atividadeAlunoService;

    @PostMapping("/create")
    public ResponseEntity<AtividadeAluno> createAtividadeAluno(@Valid @RequestBody AtividadeAluno atividadeAluno) {
        AtividadeAluno atividadeAlunoCriada = atividadeAlunoService.createAtividadeAluno(atividadeAluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(atividadeAlunoCriada.getId_atividade_aluno()).toUri();
        return ResponseEntity.created(uri).body(atividadeAlunoCriada);
    }

    
}
