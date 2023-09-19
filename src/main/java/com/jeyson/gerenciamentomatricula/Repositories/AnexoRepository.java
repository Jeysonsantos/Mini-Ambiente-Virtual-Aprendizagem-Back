package com.jeyson.gerenciamentomatricula.Repositories;

import java.sql.Blob;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jeyson.gerenciamentomatricula.Models.Anexo;

public interface AnexoRepository extends JpaRepository<Anexo, Long>{
    @Query("SELECT a FROM Anexo a WHERE a.id_postagem = :id")
    List<Anexo> findAllByPostagemId(Long id);    

    @Query("SELECT a FROM Anexo a WHERE a.id_disciplina = :id")
    List<Anexo> findAllByDisciplinaId(Long id);

    @Query("SELECT a.dados FROM Anexo a WHERE a.id_anexo = :id_anexo")
    Blob getDadosById_anexo(Long id_anexo);
}
