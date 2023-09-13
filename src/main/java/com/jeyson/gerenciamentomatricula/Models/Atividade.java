package com.jeyson.gerenciamentomatricula.Models;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
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
    public interface CreateAtividade {
    }
    public interface UpdateAtividade {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_atividade", unique = true, nullable = false, updatable = false)
    private Long id_atividade;
    
    @Column(name = "descricao_atividade", nullable = false)
    @NotNull(groups = {CreateAtividade.class, UpdateAtividade.class})
    @NotEmpty(groups = {CreateAtividade.class, UpdateAtividade.class})
    private String descricao_atividade;

    @Column(name = "data_postagem", nullable = false, updatable = false)
    private LocalDate data_postagem;

    @Column(name = "data_entrega")
    private LocalDate data_entrega;

    @Column(name = "id_disciplina")
    private Long id_disciplina;

    @Column(name = "id_postagem")
    private Long id_postagem;

    @PrePersist
    public void prePersist() {
        this.data_postagem = LocalDate.now();
    }

    
}
