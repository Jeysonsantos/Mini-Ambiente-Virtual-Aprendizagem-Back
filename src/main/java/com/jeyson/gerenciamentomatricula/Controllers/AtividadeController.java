package com.jeyson.gerenciamentomatricula.Controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeyson.gerenciamentomatricula.Models.Atividade;
import com.jeyson.gerenciamentomatricula.Services.AtividadeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/atividade")
@Validated
public class AtividadeController {

    @Autowired
    private AtividadeService atividadeService;

    @PostMapping("/create")
    @Validated(Atividade.CreateAtividade.class)
    public ResponseEntity<Atividade> createAtividade(@Valid @RequestBody Atividade atividade) {
        Atividade atividadeCriada = atividadeService.createAtividade(atividade);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(atividadeCriada.getId_atividade()).toUri();
        return ResponseEntity.created(uri).body(atividadeCriada);
    }
    
}
