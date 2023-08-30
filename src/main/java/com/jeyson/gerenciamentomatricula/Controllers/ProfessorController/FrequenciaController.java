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

import com.jeyson.gerenciamentomatricula.Models.Frequencia;
import com.jeyson.gerenciamentomatricula.Services.FrequenciaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/frequencia")
@CrossOrigin(origins = "http://localhost:4200")
@Validated
public class FrequenciaController {
    
    @Autowired
    private FrequenciaService frequenciaService;

    @PostMapping("/create")
    @Validated(Frequencia.CreateFrequencia.class)
    public ResponseEntity<Frequencia> createFrequencia(@Valid @RequestBody Frequencia frequencia){
        Frequencia frequenciaCriada = frequenciaService.createFrequencia(frequencia);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(frequenciaCriada.getId_frequencia()).toUri();
        return ResponseEntity.created(uri).body(frequenciaCriada);
    }
}
