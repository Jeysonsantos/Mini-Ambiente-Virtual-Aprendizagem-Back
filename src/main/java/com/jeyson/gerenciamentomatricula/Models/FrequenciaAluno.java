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
@Table(name = FrequenciaAluno.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class FrequenciaAluno {
    public static final String TABLE_NAME = "FrequenciaAluno";

    public interface CreateFrequenciaAluno{}
    public interface UpdateFrequenciaAluno{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_frequencia_aluno", unique = true, nullable = false, updatable = false)
    private Long id_frequencia_aluno;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false, updatable = false)
    private Aluno id_aluno;

    @ManyToOne
    @JoinColumn(name = "id_frequencia", nullable = false, updatable = false)
    private Frequencia id_frequencia;

    @Column(name = "presenca", nullable = false)
    @NotNull(groups = {CreateFrequenciaAluno.class, UpdateFrequenciaAluno.class})
    private String presenca;
    

}

