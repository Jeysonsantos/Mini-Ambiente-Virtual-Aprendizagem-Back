package com.jeyson.gerenciamentomatricula.Controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Models.Aluno.CreateAluno;
import com.jeyson.gerenciamentomatricula.Services.AlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/aluno")
@Validated
public class AlunoController {
    
    @Autowired
    private AlunoService alunoService;

    @PostMapping("/create")
    @Validated(CreateAluno.class)
    public ResponseEntity<Aluno> createAluno(@Valid @RequestBody Aluno aluno) {
        Aluno alunoCriado = alunoService.createAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoCriado.getId_aluno()).toUri();
        return ResponseEntity.created(uri).body(alunoCriado);
    }
}
