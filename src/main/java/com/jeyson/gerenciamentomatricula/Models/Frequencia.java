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
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Frequencia.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Frequencia {

    public static final String TABLE_NAME = "Frequencia";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_frequencia", unique = true, nullable = false, updatable = false)
    private Long id_frequencia;

    @ManyToOne
    @JoinColumn(name = "id_disciplina", nullable = false, updatable = false)
    private Disciplina id_materia;

    @Column(name = "data", nullable = false)
    private LocalDate data;

}
