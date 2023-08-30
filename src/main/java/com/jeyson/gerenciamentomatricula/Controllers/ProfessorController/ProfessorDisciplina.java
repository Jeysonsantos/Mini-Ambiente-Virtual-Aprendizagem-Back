package com.jeyson.gerenciamentomatricula.Controllers.ProfessorController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Models.Professor.UpdateProfessor;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminDisciplinaService;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminProfessorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor/disciplina")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorDisciplina {

    @Autowired
    private AdminProfessorService professorService;

    @Autowired
    private AdminDisciplinaService AdmindisciplinaService;

    @PutMapping("/update")
    @Validated(UpdateProfessor.class)
    public ResponseEntity<Professor> updateProfessor(@Valid @RequestBody Professor professor) {
        Professor professorAtualizado = professorService.updateProfessor(professor);
        return ResponseEntity.ok().body(professorAtualizado);
    }
    
    @GetMapping("/allByProfessor/{id}")
    public ResponseEntity<Iterable<Disciplina>> listDisciplinasByProfessorId(@PathVariable Long id) {
        Iterable<Disciplina> disciplinas = AdmindisciplinaService.findAllByProfessorId(id);
        return ResponseEntity.ok().body(disciplinas);
}

}
