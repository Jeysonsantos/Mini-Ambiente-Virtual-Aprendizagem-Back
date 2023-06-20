package com.jeyson.gerenciamentomatricula.Models;

import java.time.LocalDate;

import com.jeyson.gerenciamentomatricula.Models.Atividade.CreateAtividade;
import com.jeyson.gerenciamentomatricula.Models.Atividade.UpdateAtividade;
import com.jeyson.gerenciamentomatricula.Models.Enum.TipoMetodo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = PlanoAula.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class PlanoAula {
    private static final String TABLE_NAME = "PlanoAula";

    public interface createPlanoAula {}
    public interface updatePlanoAula{}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plano_aula", unique = true, nullable = false, updatable = false)
    private Long id_plano_aula;

    @Column(name = "tema_aula", nullable = false, length = 255)
    @NotNull(groups = {createPlanoAula.class, updatePlanoAula.class})
    @NotEmpty(groups = {createPlanoAula.class, updatePlanoAula.class})
    private String tema_aula;

    @Column(name = "conteudo", nullable = false)
    @NotNull(groups = {createPlanoAula.class, updatePlanoAula.class})
    @NotEmpty(groups = {createPlanoAula.class, updatePlanoAula.class})
    private String conteudo;
    
    @Column(name = "metodo", nullable = false, length = 50)
    @Enumerated(EnumType.STRING)
    @NotNull(groups = { CreateAtividade.class, UpdateAtividade.class })
    private TipoMetodo metodo;


    @Column(name = "dia", nullable = false)
    @NotNull(groups = {createPlanoAula.class, updatePlanoAula.class})
    private LocalDate dia;

    @JoinColumn(name = "id_disciplina", nullable = false, updatable = false)
    @ManyToOne
    private Disciplina id_disciplina;
    
}
