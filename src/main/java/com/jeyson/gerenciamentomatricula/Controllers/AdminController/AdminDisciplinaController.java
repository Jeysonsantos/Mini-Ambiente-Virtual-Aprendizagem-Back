package com.jeyson.gerenciamentomatricula.Controllers.AdminController;

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
import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Models.Disciplina.CreateDisciplina;
import com.jeyson.gerenciamentomatricula.Services.DisciplinaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/disciplina")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class AdminDisciplinaController {
    @Autowired
    private DisciplinaService disciplinaService;
    
    @PostMapping("/create")
    @Validated(CreateDisciplina.class)
    public ResponseEntity<Disciplina> createDisciplina(@Valid @RequestBody Disciplina disciplina) {
        Disciplina disciplinaCriada = disciplinaService.createDisciplina(disciplina);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplinaCriada.getId_disciplina()).toUri();
        return ResponseEntity.created(uri).body(disciplinaCriada);
    }

}
