package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jeyson.gerenciamentomatricula.Models.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long>{
    
}
