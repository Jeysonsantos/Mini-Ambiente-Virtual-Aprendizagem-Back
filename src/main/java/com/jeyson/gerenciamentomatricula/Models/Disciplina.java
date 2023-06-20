package com.jeyson.gerenciamentomatricula.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Disciplina.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Disciplina {
    public static final String TABLE_NAME = "Disciplinas";

    public interface CreateDisciplina{
    }
    public interface UpdateDisciplina{
    }
    @Id
    @Column(name = "id_disciplina", unique = true, nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_disciplina;

    @JoinColumn(name = "id_professor", nullable = false, updatable = false)
    @ManyToOne
    private Professor id_professor;

    @Column(name = "nome", nullable = false, length = 255)
    @NotNull(groups = { CreateDisciplina.class})
    @NotEmpty(groups = { CreateDisciplina.class})
    private String nome;

    @Column(name = "codigo", nullable = false, length = 7,unique = true)
    @NotNull(groups = { CreateDisciplina.class})
    @NotEmpty(groups = { CreateDisciplina.class})
    private String codigo;

    @Column(name = "carga_horaria", nullable = false)
    @NotNull(groups = { CreateDisciplina.class})
    private int carga_horaria;

    @Column(name = "ementa")
    @NotNull(groups = { CreateDisciplina.class, UpdateDisciplina.class})
    @NotEmpty(groups = { CreateDisciplina.class, UpdateDisciplina.class})
    private String ementa;
    
}
