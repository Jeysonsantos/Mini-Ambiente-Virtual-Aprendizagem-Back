package com.jeyson.gerenciamentomatricula.Controllers.AdminController;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Models.Disciplina.CreateDisciplina;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminDisciplinaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin/disciplina")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class AdminDisciplinaController {
    @Autowired
    private AdminDisciplinaService AdmindisciplinaService;
    
    @PostMapping("/create")
    @Validated(CreateDisciplina.class)
    public ResponseEntity<Disciplina> createDisciplina(@Valid @RequestBody Disciplina disciplina) {
        Disciplina disciplinaCriada = AdmindisciplinaService.createDisciplina(disciplina);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(disciplinaCriada.getId_disciplina()).toUri();
        return ResponseEntity.created(uri).body(disciplinaCriada);
    }

    @PutMapping("/update")
    public ResponseEntity<Disciplina> updateDisciplina(@Valid @RequestBody Disciplina disciplina) {
        Disciplina disciplinaAtualizada = AdmindisciplinaService.updateDisciplina(disciplina);
        return ResponseEntity.ok().body(disciplinaAtualizada);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> excluirDisciplina(@PathVariable Long id) {
        AdmindisciplinaService.deleteDisciplinaById(id);
        return ResponseEntity.ok().build();
    }
    

    @GetMapping("/all")
    public ResponseEntity<Iterable<Disciplina>> listDisciplinas() {
        return ResponseEntity.ok().body(AdmindisciplinaService.getAllDisciplinas());
    }

    @GetMapping("/checkCodigoExists/{codigo}")
    public ResponseEntity<?> checkMatriculaExists(@PathVariable String codigo) {
        boolean exists = AdmindisciplinaService.checkCodigoExists(codigo);
        return ResponseEntity.ok(exists);
    }

}
