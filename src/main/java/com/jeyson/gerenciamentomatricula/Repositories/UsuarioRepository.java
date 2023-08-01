package com.jeyson.gerenciamentomatricula.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jeyson.gerenciamentomatricula.Models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    boolean existsByCpf(String cpf);
      @Query("SELECT u FROM Usuario u WHERE u.id_aluno_professor = :idAlunoProfessor")
    Usuario findByIdAlunoProfessor(Long idAlunoProfessor);

    @Modifying
    @Query("DELETE FROM Usuario u WHERE u.id_aluno_professor = :idAlunoProfessor")
    void deleteByIdAlunoProfessor(@Param("idAlunoProfessor") Long idAlunoProfessor);

}
