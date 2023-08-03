package com.jeyson.gerenciamentomatricula.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.Usuario;
import com.jeyson.gerenciamentomatricula.Repositories.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario createUsuario(Usuario usuario) {
        usuario.setId_usuario(null);
        usuario = this.usuarioRepository.save(usuario);
        return usuario;
    }

    @Transactional
    public Usuario updateUsuario(Usuario usuario) {
        usuario = this.usuarioRepository.save(usuario);
        return usuario;
    }

    public List<Usuario> getAllUsuarios() {
        return this.usuarioRepository.findAll();
    }
    
    public Usuario getUsuarioByIdAlunoProfessor(Long id) {
        return this.usuarioRepository.findByIdAlunoProfessor(id);
    }

    @Transactional
    public Boolean deleteUsuarioByIdAlunoProfessor(Long id) {
        this.usuarioRepository.deleteByIdAlunoProfessor(id);
        return true;
}   
    public Boolean existsByCpf(String cpf) {
        return this.usuarioRepository.existsByCpf(cpf);
    }

}
