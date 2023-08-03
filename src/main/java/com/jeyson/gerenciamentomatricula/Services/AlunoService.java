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

        Usuario usuario = new Usuario();
        usuario.setCpf(aluno.getCpf());
        String cpf = aluno.getCpf();
        String senha = cpf.substring(0, 3) + cpf.substring(cpf.length() - 2);

        usuario.setSenha(senha);
        usuario.setId_aluno_professor(aluno.getId_aluno());
        usuario.setTipo_usuario("aluno");
        usuario.setNome(aluno.getNome());
        usuarioService.createUsuario(usuario);
        
        return aluno;
    }

    @Transactional
    public Aluno updateAluno(Aluno aluno) {
        aluno = this.alunoRepository.save(aluno);
        String cpf = aluno.getCpf();
        String senha = cpf.substring(0, 3) + cpf.substring(cpf.length() - 2);

        Usuario Usuario = usuarioService.getUsuarioByIdAlunoProfessor(aluno.getId_aluno());
        if(Usuario != null){
            Usuario.setCpf(aluno.getCpf());
            Usuario.setSenha(senha);
            Usuario.setNome(aluno.getNome());
            usuarioService.updateUsuario(Usuario);
        }else{
            Usuario = new Usuario();
            Usuario.setCpf(cpf);
            Usuario.setSenha(senha);
            Usuario.setId_aluno_professor(aluno.getId_aluno());
            Usuario.setTipo_usuario("aluno");
            Usuario.setNome(aluno.getNome());
            usuarioService.createUsuario(Usuario);
        }
        return aluno;
    }

    @Transactional
    public void deleteAluno(Long id) {
        usuarioService.deleteUsuarioByIdAlunoProfessor(id);
        this.alunoRepository.deleteById(id);    
        
    }

    @Transactional
    public String getNomeAluno(Long id) {
        return alunoRepository.findById(id).get().getNome();
    }

    public List<Aluno> getAllAlunos() {
        List<Aluno> alunos = this.alunoRepository.findAll();
        //CreateAllUsuario();
    
        return alunos;
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

    public Boolean CreateAllUsuario() {
        List<Aluno> alunos = this.alunoRepository.findAll();
        for (Aluno aluno : alunos) {
            if(usuarioService.existsByCpf(aluno.getCpf())){
                continue;
            }else{
                Usuario Usuario = new Usuario();
                Usuario.setCpf(aluno.getCpf());
                String cpf = aluno.getCpf();
                String senha = cpf.substring(0, 3) + cpf.substring(cpf.length() - 2);
                Usuario.setSenha(senha);
                Usuario.setId_aluno_professor(aluno.getId_aluno());
                Usuario.setTipo_usuario("aluno");   
                Usuario.setNome(aluno.getNome());
                usuarioService.createUsuario(Usuario);
                System.out.println("Criou usuario para o aluno: " + aluno.getNome());
            }
        }

        return true;
    }
}
