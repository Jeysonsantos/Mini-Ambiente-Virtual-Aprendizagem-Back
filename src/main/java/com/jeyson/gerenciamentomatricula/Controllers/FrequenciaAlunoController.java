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

import com.jeyson.gerenciamentomatricula.Models.FrequenciaAluno;
import com.jeyson.gerenciamentomatricula.Services.FrequenciaAlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/frequenciaaluno")
@Validated
public class FrequenciaAlunoController {
    
    @Autowired
    private FrequenciaAlunoService frequenciaAlunoService;

    @PostMapping("/create")
    @Validated(FrequenciaAluno.CreateFrequenciaAluno.class)
    public ResponseEntity<FrequenciaAluno> createFrequenciaAluno(@Valid @RequestBody FrequenciaAluno frequenciaAluno){
        FrequenciaAluno frequenciaAlunoCriada = frequenciaAlunoService.createFrequenciaAluno(frequenciaAluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(frequenciaAlunoCriada.getId_frequencia_aluno()).toUri();
        return ResponseEntity.created(uri).body(frequenciaAlunoCriada);
    }
}
