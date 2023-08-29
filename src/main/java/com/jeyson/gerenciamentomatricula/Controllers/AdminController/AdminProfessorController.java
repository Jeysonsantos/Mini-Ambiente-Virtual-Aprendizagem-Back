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

import com.jeyson.gerenciamentomatricula.Models.Aluno.UpdateAluno;
import com.jeyson.gerenciamentomatricula.Models.Professor.UpdateProfessor;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminProfessorService;
import com.jeyson.gerenciamentomatricula.Models.Professor;

import jakarta.validation.Valid;

@Validated
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin/professor")
public class AdminProfessorController {

    @Autowired
    private AdminProfessorService professorService;

    @PostMapping("/create")
    @Validated(Professor.CreateProfessor.class)
    public ResponseEntity<Professor> createProfessor(@Valid @RequestBody Professor professor) {
        Professor professorCriado = professorService.createProfessor(professor);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(professorCriado.getId_professor()).toUri();
        return ResponseEntity.created(uri).body(professorCriado);
    }

    @PutMapping("/update")
    @Validated(UpdateProfessor.class)
    public ResponseEntity<Professor> updateProfessor(@Valid @RequestBody Professor professor) {
        Professor professorAtualizado = professorService.updateProfessor(professor);
        return ResponseEntity.ok().body(professorAtualizado);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> excluirProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/all")
    public ResponseEntity<Iterable<Professor>> listProfessores() {
        return ResponseEntity.ok().body(professorService.getAllAlunos());
    }

    @GetMapping("/checkCodigoExists/{codigo}")
    public ResponseEntity<?> checkCodigoExists(@PathVariable String codigo) {
        boolean exists = professorService.checkCodigoExists(codigo);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkCpfExists/{cpf}")
    public ResponseEntity<?> checkCpfExists(@PathVariable String cpf) {
        boolean exists = professorService.checkCpfExists(cpf);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkRgExists/{rg}")
    public ResponseEntity<?> checkRgExists(@PathVariable String rg) {
        boolean exists = professorService.checkRgExists(rg);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkTelefoneExists/{telefone}")
    public ResponseEntity<?> checkTelefoneExists(@PathVariable String telefone) {
        boolean exists = professorService.checkTelefoneExists(telefone);
        return ResponseEntity.ok(exists);
    }

    @GetMapping("/checkEmailExists/{email}")
    public ResponseEntity<?> checkEmailExists(@PathVariable String email) {
        boolean exists = professorService.checkEmailExists(email);
        return ResponseEntity.ok(exists);
    }

}   
