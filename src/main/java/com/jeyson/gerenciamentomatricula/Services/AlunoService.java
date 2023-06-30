package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Models.Usuario;
import com.jeyson.gerenciamentomatricula.Repositories.AlunoRepository;


@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public Aluno createAluno(Aluno aluno) {
        aluno.setId_aluno(null);
        aluno = this.alunoRepository.save(aluno);

        Usuario Usuario = new Usuario();

        Usuario.setCpf(aluno.getCpf());
        String cpf = aluno.getCpf();
        String senha = cpf.substring(0, 3) + cpf.substring(cpf.length() - 2);
        Usuario.setSenha(senha);
        Usuario.setId_aluno_professor(aluno.getId_aluno());
        Usuario.setTipo_usuario("aluno");

        usuarioService.createUsuario(Usuario);

        return aluno;
    }

}
