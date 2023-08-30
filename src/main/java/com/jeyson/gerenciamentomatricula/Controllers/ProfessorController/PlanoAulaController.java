package com.jeyson.gerenciamentomatricula.Controllers.ProfessorController;

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

import com.jeyson.gerenciamentomatricula.Models.PlanoAula;
import com.jeyson.gerenciamentomatricula.Services.PlanoAulaService;

import jakarta.validation.Valid;

@RestController
@Validated
@RequestMapping("/planoaula")
@CrossOrigin(origins = "http://localhost:4200")
public class PlanoAulaController {
    
    @Autowired
    private PlanoAulaService planoAulaService;

    @PostMapping("/create")
    @Validated(PlanoAula.createPlanoAula.class)
    public ResponseEntity<PlanoAula> createPlanoAula(@Valid @RequestBody PlanoAula planoAula) {
        PlanoAula planoAulaCriado = planoAulaService.createPlanoAula(planoAula);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(planoAulaCriado.getId_plano_aula()).toUri();
        return ResponseEntity.created(uri).body(planoAulaCriado);
    }

}
