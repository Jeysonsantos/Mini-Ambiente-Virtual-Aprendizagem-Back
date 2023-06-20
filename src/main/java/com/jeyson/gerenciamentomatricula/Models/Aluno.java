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
@Table(name = Aluno.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Aluno {
    
    public interface CreateAluno {
    }
    public interface UpdateAluno {
    }
    public static final String TABLE_NAME = "Alunos";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_aluno", unique = true, nullable = false, updatable = false)
    private Long id_aluno;

    @Column(name = "nome", nullable = false, length = 255)
    @NotNull(groups = { CreateAluno.class, UpdateAluno.class })
    @NotEmpty(groups = { CreateAluno.class, UpdateAluno.class })
    @Size(min = 3, max = 255)
    private String nome;

    @Column(name = "cpf", nullable = false, length = 11, unique = true)
    @NotNull(groups = { CreateAluno.class })
    @NotEmpty(groups = { CreateAluno.class })
    @Size(min = 11, max = 11)
    private String cpf;

    @Column(name = "rg", nullable = false, length = 8, unique = true)
    @NotNull(groups = { CreateAluno.class })
    @NotEmpty(groups = { CreateAluno.class })
    @Size(min = 8, max = 8)
    private String rg;

    @Column(name = "matricula", nullable = false, length = 8, unique = true)
    @NotNull(groups = { CreateAluno.class })
    @NotEmpty(groups = { CreateAluno.class })
    @Size(min = 8, max = 8)
    private String matricula;

    @Column(name = "telefone", nullable = false, length = 11, unique = true)
    @NotNull(groups = { CreateAluno.class, UpdateAluno.class })
    @NotEmpty(groups = { CreateAluno.class, UpdateAluno.class })
    @Size(min = 11, max = 11)
    private String telefone;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    @NotNull(groups = { CreateAluno.class, UpdateAluno.class})
    @NotEmpty(groups = { CreateAluno.class, UpdateAluno.class })
    @Size(min = 3, max = 255)
    private String email;

}
