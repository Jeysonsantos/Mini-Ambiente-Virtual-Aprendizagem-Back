package com.jeyson.gerenciamentomatricula.Services.AdminService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Models.Usuario;
import com.jeyson.gerenciamentomatricula.Repositories.ProfessorRepository;


@Service
public class AdminProfessorService {
    
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
    public Professor updateProfessor(Professor professor) {
        professor = this.professorRepository.save(professor);
        String cpf = professor.getCpf();
        String senha = cpf.substring(0, 3) + cpf.substring(cpf.length() - 2);

        Usuario Usuario = usuarioService.getUsuarioByIdAlunoProfessor(professor.getId_professor());
        if(Usuario != null){
            Usuario.setCpf(professor.getCpf());
            Usuario.setSenha(senha);
            Usuario.setNome(professor.getNome());
            usuarioService.updateUsuario(Usuario);
        }else{
            Usuario = new Usuario();
            Usuario.setCpf(cpf);
            Usuario.setSenha(senha);
            Usuario.setId_aluno_professor(professor.getId_professor());
            Usuario.setTipo_usuario("professor");
            Usuario.setNome(professor.getNome());
            usuarioService.createUsuario(Usuario);
        }
        return professor;
    }

    @Transactional
    public void deleteProfessor(Long id) {
        usuarioService.deleteUsuarioByIdAlunoProfessor(id);
        this.professorRepository.deleteById(id);
    }

    @Transactional
    public String getNomeProfessor(Long id) {
        return professorRepository.findById(id).get().getNome();
    }

    public List<Professor> getAllAlunos() {
        List<Professor> professor = this.professorRepository.findAll();
        ///CreateAllUsuario();
    
        return professor;
    }

    public Boolean checkCodigoExists(String codigo) {
        return this.professorRepository.existsByCodigo(codigo);
    }

    public Boolean checkCpfExists(String cpf) {
        return this.professorRepository.existsByCpf(cpf);
    }

    public Boolean checkRgExists(String rg) {
        return this.professorRepository.existsByRg(rg);
    }

    public Boolean checkTelefoneExists(String telefone) {
        return this.professorRepository.existsByTelefone(telefone);
    }

    public Boolean checkEmailExists(String email) {
        return this.professorRepository.existsByEmail(email);
    }

    public Boolean CreateAllUsuario() {
        List<Professor> professores = this.professorRepository.findAll();
        for (Professor professor : professores) {
            if(usuarioService.existsByCpf(professor.getCpf())){
                continue;
            }else{
                Usuario Usuario = new Usuario();
                Usuario.setCpf(professor.getCpf());
                String cpf = professor.getCpf();
                String senha = cpf.substring(0, 3) + cpf.substring(cpf.length() - 2);
                Usuario.setSenha(senha);
                Usuario.setId_aluno_professor(professor.getId_professor());
                Usuario.setTipo_usuario("professor");   
                Usuario.setNome(professor.getNome());
                usuarioService.createUsuario(Usuario);
            }
        }

        return true;
    }
    
}
