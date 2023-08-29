package com.jeyson.gerenciamentomatricula.Controllers.AlunoController;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Services.AlunoService.AlunoService;


@RestController
@RequestMapping("/aluno")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class AlunoController {

    @Autowired
    private AlunoService alunoService;

    @GetMapping("/getEmailById/{id}")
    public ResponseEntity<String> getEmailById(@PathVariable Long id) {
        return ResponseEntity.ok().body(alunoService.getEmailById(id));
    }

    @GetMapping("/getAlunoById/{id}")
    public ResponseEntity<Aluno> getAlunoById(@PathVariable Long id) {
        return ResponseEntity.ok().body(alunoService.getAlunoById(id));
    }
}
