package com.jeyson.gerenciamentomatricula.Models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = AtividadeAluno.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class AtividadeAluno {
    private static final String TABLE_NAME = "AtividadeAluno";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;
    
    @JoinColumn(name = "id_aluno", nullable = false, updatable = false)
    @ManyToOne
    private Aluno id_aluno;

    @JoinColumn(name = "id_atividade", nullable = false, updatable = false)
    @ManyToOne
    private Atividade id_atividade;

    @Column(name = "nota", nullable = false)
    private float nota;

}
