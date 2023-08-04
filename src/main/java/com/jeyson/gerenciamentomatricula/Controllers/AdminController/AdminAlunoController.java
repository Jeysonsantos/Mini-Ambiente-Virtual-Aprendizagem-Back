package com.jeyson.gerenciamentomatricula.Controllers.AdminController;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Models.Aluno.CreateAluno;
import com.jeyson.gerenciamentomatricula.Models.Aluno.UpdateAluno;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminAlunoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/aluno")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class AdminAlunoController {
    
    @Autowired
    private AdminAlunoService alunoService;

    @PostMapping("/create")
    @Validated(CreateAluno.class)
    public ResponseEntity<Aluno> createAluno(@Valid @RequestBody Aluno aluno) {
        Aluno alunoCriado = alunoService.createAluno(aluno);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(alunoCriado.getId_aluno()).toUri();
        return ResponseEntity.created(uri).body(alunoCriado);
    }

    @PutMapping("/update")
    @Validated(UpdateAluno.class)
    public ResponseEntity<Aluno> updateAluno(@Valid @RequestBody Aluno aluno) {
        Aluno alunoAtualizado = alunoService.updateAluno(aluno);
        return ResponseEntity.ok().body(alunoAtualizado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> excluirAluno(@PathVariable Long id) {
        alunoService.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Aluno>> listAlunos() {
        return ResponseEntity.ok().body(alunoService.getAllAlunos());
    }
    @GetMapping("/checkMatriculaExists/{matricula}")
    public ResponseEntity<?> checkMatriculaExists(@PathVariable String matricula) {
        boolean exists = alunoService.checkMatriculaExists(matricula);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkCpfExists/{cpf}")
    public ResponseEntity<?> checkCpfExists(@PathVariable String cpf) {
        boolean exists = alunoService.checkCpfExists(cpf);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkRgExists/{rg}")
    public ResponseEntity<?> checkRgExists(@PathVariable String rg) {
        boolean exists = alunoService.checkRgExists(rg);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkTelefoneExists/{telefone}")
    public ResponseEntity<?> checkTelefoneExists(@PathVariable String telefone) {
        boolean exists = alunoService.checkTelefoneExists(telefone);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkEmailExists/{email}")
    public ResponseEntity<?> checkEmailExists(@PathVariable String email) {
        boolean exists = alunoService.checkEmailExists(email);
        return ResponseEntity.ok(exists);
    }

}
