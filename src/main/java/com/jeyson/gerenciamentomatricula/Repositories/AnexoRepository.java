package com.jeyson.gerenciamentomatricula.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeyson.gerenciamentomatricula.Models.Anexo;

public interface AnexoRepository extends JpaRepository<Anexo, Long>{
    @Query("SELECT a FROM Anexo a WHERE a.id_postagem = :id_postagem")
    List<Anexo> findAllByPostagemId(Long id_postagem);    
}
