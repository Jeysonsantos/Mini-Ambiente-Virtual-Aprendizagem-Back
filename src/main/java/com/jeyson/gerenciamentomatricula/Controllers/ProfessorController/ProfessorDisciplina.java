package com.jeyson.gerenciamentomatricula.Controllers.ProfessorController;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jeyson.gerenciamentomatricula.Models.Anexo;
import com.jeyson.gerenciamentomatricula.Models.Atividade;
import com.jeyson.gerenciamentomatricula.Models.Disciplina;
import com.jeyson.gerenciamentomatricula.Models.Postagem;
import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Models.Professor.UpdateProfessor;
import com.jeyson.gerenciamentomatricula.Services.AnexoService;
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

    @PostMapping("{id_disciplina}/postagens/{id_postagem}/{id_atividade}/upload")
    public ResponseEntity<Anexo> uploadAnexo(
            @PathVariable Long id_postagem,
            @PathVariable Long id_atividade,
            @PathVariable Long id_disciplina,
            @RequestParam("file") MultipartFile file) {
        // Aqui você pode lidar com o arquivo enviado e outros parâmetros
        // Salvar o arquivo, processar dados, etc.

        Anexo anexo = new Anexo();
        anexo.setNome(file.getOriginalFilename());
        anexo.setTipo(file.getContentType());
        anexo.setId_atividade(id_atividade);
        anexo.setId_postagem(id_postagem);
        anexo.setId_disciplina(id_disciplina);

        try {
            byte[] bytesDoArquivo = file.getBytes();
            anexo.setDados(bytesDoArquivo);
            professorService.createAnexo(anexo);
            return ResponseEntity.ok(anexo);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(null); // Ou envie uma mensagem de erro apropriada
        }
    }

    @GetMapping("{id}")
    public ResponseEntity<Disciplina> getDisciplinaById(@PathVariable Long id) {
        Disciplina disciplina = AdmindisciplinaService.findDisciplinaById(id);
        return ResponseEntity.ok().body(disciplina);
    }

    @GetMapping("/{disciplinaId}/postagens")
    public ResponseEntity<Iterable<Postagem>> listPostagensByDisciplinaId(@PathVariable Long disciplinaId) {
        Iterable<Postagem> postagens = professorService.findAllPostagensByDisciplinaId(disciplinaId);
        return ResponseEntity.ok().body(postagens);
    }

    @GetMapping("/postagens/{id_postagem}/anexos")
    public ResponseEntity<List<Anexo>> listAnexosByPostagemId(@PathVariable Long id_postagem) {
        List<Anexo> anexos = new ArrayList<Anexo>();
        anexos = professorService.findAllAnexosByPostagemId(id_postagem);
        return ResponseEntity.ok().body(anexos);
    }

    @GetMapping("/{id_disciplina}/anexos")
    public ResponseEntity<List<Anexo>> listAnexosByDisciplinaId(@PathVariable Long id_disciplina) {
        List<Anexo> anexos = new ArrayList<Anexo>();
        anexos = professorService.findAllAnexosByDisciplinaId(id_disciplina);
        
        return ResponseEntity.ok().body(anexos);
    }

    @GetMapping("postagens/{id_postagem}/atividade")
    public ResponseEntity<Atividade> getAtividadeByPostagemId(@PathVariable Long id_postagem) {
        Atividade atividade = professorService.findAtividadeByPostagemId(id_postagem);
        return ResponseEntity.ok().body(atividade);
    }

    @GetMapping("postagens/atividade/{id_atividade}")
    public ResponseEntity<Atividade> getAtividadeById(@PathVariable Long id_atividade) {
        Atividade atividade = professorService.findAtividadeById(id_atividade);
        return ResponseEntity.ok().body(atividade);
    }
}
