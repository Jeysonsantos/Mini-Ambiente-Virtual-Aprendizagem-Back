package com.jeyson.gerenciamentomatricula.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = DisciplinaAluno.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DisciplinaAluno {
    private static final String TABLE_NAME = "DisciplinaAluno";

    public interface CreateDisciplinaAluno{}
    public interface UpdateDisciplinaAluno{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina_aluno", unique = true, nullable = false, updatable = false)
    private Long id_disciplina_aluno;

    @JoinColumn(name = "id_aluno", nullable = false, updatable = false)
    @NotNull
    @ManyToOne
    private Aluno id_aluno;

    @JoinColumn(name = "id_disciplina", nullable = false, updatable = false)
    @NotNull
    @ManyToOne
    private Disciplina id_disciplina;

    @Column(name = "nota", nullable = false, columnDefinition = "float default 0.0")
    @NotNull(groups = {CreateDisciplinaAluno.class, UpdateDisciplinaAluno.class})
    private float nota;


    
}
