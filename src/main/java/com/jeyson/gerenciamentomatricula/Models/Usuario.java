package com.jeyson.gerenciamentomatricula.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Usuario.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Usuario {
    
    public static final String TABLE_NAME = "Usuarios";

    public interface CreateUsuario {
    }

    public interface UpdateUsuario {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", updatable = false)
    private Long id_usuario;

    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "senha", nullable = false, length = 255)
    @Size(min = 3, max = 255)
    private String senha;

    @Column(name = "id_aluno/professor", nullable = false, updatable = false)
    private Long id_aluno_professor;

    @NotNull(groups = { CreateUsuario.class, UpdateUsuario.class })
    @NotEmpty(groups = { CreateUsuario.class, UpdateUsuario.class })
    @Column(name = "tipo", nullable = false, length = 10)
    private String tipo_usuario;
}
