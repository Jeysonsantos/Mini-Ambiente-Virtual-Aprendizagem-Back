package com.jeyson.gerenciamentomatricula.Models;


import java.time.LocalDate;

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
@Table(name = Atividade.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Atividade {

    private static final String TABLE_NAME = "Atividades";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade", unique = true, nullable = false, updatable = false)
    private Long id_atividade;
    
    @Column(name = "atividade", nullable = false)
    @NotNull
    @NotEmpty
    private String atividade;

    @Column(name = "tipo", nullable = false, length = 50)
    @NotNull
    @NotEmpty
    private String tipo;

    @Column(name = "data_postagem", nullable = false)
    @NotNull
    @NotEmpty
    private LocalDate data;

    @Column(name = "data_entrega")
    private LocalDate data_entrega;

    @ManyToOne(optional = false, targetEntity = Disciplina.class)
    @JoinColumn(name = "id_disciplina", nullable = false, updatable = false)
    private Long id_disciplina;

    @JoinColumn(name = "id_plano_aula", nullable = false, updatable = false)
    @ManyToOne(optional = false, targetEntity = PlanoAula.class)
    private PlanoAula id_plano_aula;

}
