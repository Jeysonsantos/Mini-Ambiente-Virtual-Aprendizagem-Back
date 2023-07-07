package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Models.Usuario;
import com.jeyson.gerenciamentomatricula.Repositories.ProfessorRepository;


@Service
public class ProfessorService {
    
    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public Professor createProfessor(Professor professor) {
        professor.setId_professor(null);
        professor = this.professorRepository.save(professor);

        Usuario usuario = new Usuario();

        usuario.setCpf(professor.getCpf());
        String cpf = professor.getCpf();
        String senha = cpf.substring(0, 3) + cpf.substring(cpf.length() - 2);
        usuario.setSenha(senha);
        usuario.setId_aluno_professor(professor.getId_professor());
        usuario.setTipo_usuario("professor");
        usuario.setNome(professor.getNome());

        usuarioService.createUsuario(usuario);

        return professor;
    }

    @Transactional
    public String getNomeProfessor(Long id) {
        return professorRepository.findById(id).get().getNome();
    }
}
