package com.jeyson.gerenciamentomatricula.Services;

import java.util.List;

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
        Usuario.setNome(aluno.getNome());

        usuarioService.createUsuario(Usuario);

        return aluno;
    }

    @Transactional
    public String getNomeAluno(Long id) {
        return alunoRepository.findById(id).get().getNome();
    }

    public List<Aluno> getAllAlunos() {
        return this.alunoRepository.findAll();
    }

    public Boolean checkMatriculaExists(String matricula) {
        return this.alunoRepository.existsByMatricula(matricula);
    }

    public Boolean checkCpfExists(String cpf) {
        return this.alunoRepository.existsByCpf(cpf);
    }

    public Boolean checkRgExists(String rg) {
        return this.alunoRepository.existsByRg(rg);
    }

    public Boolean checkTelefoneExists(String telefone) {
        return this.alunoRepository.existsByTelefone(telefone);
    }

    public Boolean checkEmailExists(String email) {
        return this.alunoRepository.existsByEmail(email);
    }
}
