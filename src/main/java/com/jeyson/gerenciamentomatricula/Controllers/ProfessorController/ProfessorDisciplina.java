package com.jeyson.gerenciamentomatricula.Controllers.ProfessorController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jeyson.gerenciamentomatricula.Models.Anexo;
import com.jeyson.gerenciamentomatricula.Models.Atividade;
import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Models.Postagem;
import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Models.Professor.UpdateProfessor;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminDisciplinaService;
import com.jeyson.gerenciamentomatricula.Services.AdminService.AdminProfessorService;
import com.jeyson.gerenciamentomatricula.Services.ProfessorServicee.ProfessorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/professor/disciplina")
@Validated
@CrossOrigin(origins = "http://localhost:4200")
public class ProfessorDisciplina {

    @Autowired
    private AdminProfessorService AdminprofessorService;

    @Autowired
    private AdminDisciplinaService AdmindisciplinaService;

    @Autowired
    private ProfessorService professorService;


    @PutMapping("/update")
    @Validated(UpdateProfessor.class)
    public ResponseEntity<Professor> updateProfessor(@Valid @RequestBody Professor professor) {
        Professor professorAtualizado = AdminprofessorService.updateProfessor(professor);
        return ResponseEntity.ok().body(professorAtualizado);
    }
    
    @GetMapping("/allByProfessor/{id}")
    public ResponseEntity<Iterable<Disciplina>> listDisciplinasByProfessorId(@PathVariable Long id) {
        Iterable<Disciplina> disciplinas = AdmindisciplinaService.findAllByProfessorId(id);
        return ResponseEntity.ok().body(disciplinas);
    }
    
    @PostMapping("/{id}/createPostagem")
    public ResponseEntity<Postagem> createPostagem(@PathVariable Long id, @RequestBody Postagem postagem) {
        
        Postagem postagemCriada = professorService.createPostagem(postagem);
        return ResponseEntity.ok().body(postagemCriada);
    }

    @PostMapping("/postagens/atividade/create")
    public ResponseEntity<Atividade> createAtividade(@RequestBody Atividade atividade) {
        Atividade atividadeCriada = professorService.createAtividade(atividade);
        return ResponseEntity.ok().body(atividadeCriada);
    }

    @PostMapping("/postagens/{id_postagem}/{id_atividade}/upload")
    public ResponseEntity<List<Anexo>> uploadAnexo(@PathVariable Long id_postagem, @PathVariable Long id_atividade,
            @RequestBody List<byte[]> lista_arquivos) {
        Anexo anexo = new Anexo();
        List<Anexo> anexos = new ArrayList<Anexo>();
        for (byte[] arquivo : lista_arquivos) {
            anexo.setArquivo(arquivo);
            anexo.setDescricao("teste");
            anexo.setId_atividade(id_atividade);
            anexo.setId_postagem(id_postagem);
            Anexo anexoCriado = professorService.createAnexo(anexo);

            anexos.add(anexoCriado);
        }

        
        return ResponseEntity.ok().body(anexos);
    }
    


    @GetMapping("{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Long id) {
        Disciplina disciplina = AdmindisciplinaService.findDisciplinaById(id);
        return ResponseEntity.ok().body(disciplina);
    }

}
