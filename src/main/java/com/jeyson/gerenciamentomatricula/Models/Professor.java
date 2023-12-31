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
@Table(name = Professor.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Professor {

    public interface CreateProfessor {
    }
    public interface UpdateProfessor {
    }

    public static final String TABLE_NAME = "Professores";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor", unique = true, nullable = false, updatable = false)
    private Long id_professor;

    @Column(name = "nome", nullable = false, length = 255)
    @NotNull(groups = { CreateProfessor.class, UpdateProfessor.class })
    @NotEmpty(groups = { CreateProfessor.class, UpdateProfessor.class })
    @Size(min = 3, max = 255)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    @NotNull(groups = { CreateProfessor.class, UpdateProfessor.class })
    @NotEmpty(groups = { CreateProfessor.class, UpdateProfessor.class })
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "rg", nullable = false, length = 8, unique = true)
    @NotNull(groups = { CreateProfessor.class, UpdateProfessor.class })
    @NotEmpty(groups = { CreateProfessor.class, UpdateProfessor.class })
    @Size(min = 4, max = 15)
    private String rg;

    @Column(name = "codigo", nullable = false, length = 8, unique = true)
    @NotNull(groups = { CreateProfessor.class, UpdateProfessor.class })
    @NotEmpty(groups = { CreateProfessor.class, UpdateProfessor.class })
    @Size(min = 8, max = 8)
    private String codigo;

    @Column(name = "email", nullable = false, length = 255)
    @NotNull(groups = { CreateProfessor.class, UpdateProfessor.class })
    @NotEmpty(groups = { CreateProfessor.class, UpdateProfessor.class })
    @Size(min = 3, max = 255)
    private String email;

    @Column(name = "telefone", nullable = false, length = 11)
    @NotNull(groups = { CreateProfessor.class, UpdateProfessor.class })
    @NotEmpty(groups = { CreateProfessor.class, UpdateProfessor.class })
    @Size(min = 8, max = 15)
    private String telefone;

}
