package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
