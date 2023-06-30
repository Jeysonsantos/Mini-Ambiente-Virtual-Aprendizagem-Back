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

import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Services.ProfessorService;

import jakarta.validation.Valid;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @PostMapping("/create")
    @Validated(Professor.CreateProfessor.class)
    public ResponseEntity<Professor> createProfessor(@Valid @RequestBody Professor professor) {
        Professor professorCriado = professorService.createProfessor(professor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professorCriado.getId_professor()).toUri();
        return ResponseEntity.created(uri).body(professorCriado);
    }

}   
