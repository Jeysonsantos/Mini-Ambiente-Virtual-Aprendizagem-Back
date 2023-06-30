package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.Aluno;
import com.jeyson.gerenciamentomatricula.Models.Professor;
import com.jeyson.gerenciamentomatricula.Repositories.AlunoRepository;
import com.jeyson.gerenciamentomatricula.Repositories.ProfessorRepository;
import com.jeyson.gerenciamentomatricula.Repositories.UsuarioRepository;

@Service
public class AuthService {
    
    private AlunoRepository alunoRepository;
    
    private ProfessorRepository professorRepository;
    
    private UsuarioRepository usuarioRepository;

    public AuthService(AlunoRepository alunoRepository, ProfessorRepository professorRepository,
            UsuarioRepository usuarioRepository) {
        this.alunoRepository = alunoRepository;
        this.professorRepository = professorRepository;
        this.usuarioRepository = usuarioRepository;
    }
    
    @Transactional
    public Long obterIdUsuarioPorCpf(String cpf) {
        Aluno aluno = alunoRepository.findByCpf(cpf);
        if (aluno != null) {
            return aluno.getId_aluno();
        }
        
        Professor professor = professorRepository.findByCpf(cpf);
        if (professor != null) {
            return professor.getId_professor();
        }
        
        return null;
    }

    public String obterSenhaPorIdUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).get().getSenha();
    }

    public String obterTipoUsuarioPorIdUsuario(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).get().getTipo_usuario();

    }
}
