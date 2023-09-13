package com.jeyson.gerenciamentomatricula.Models;

import java.time.LocalDate;
import java.util.List;

import com.jeyson.gerenciamentomatricula.Models.Enum.TipoPostagem;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = Postagem.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Postagem {

    public interface CreatePostagem {
    }
    public interface UpdatePostagem {
    }
    public static final String TABLE_NAME = "Postagens";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postagem", unique = true, nullable = false, updatable = false)
    private Long id_postagem;

    @Column(name = "autor", nullable = false)
    @NotNull(groups = {CreatePostagem.class, UpdatePostagem.class})
    @NotEmpty(groups = {CreatePostagem.class, UpdatePostagem.class})
    private String autor;

    @Column(name = "conteudo", nullable = false)
    @NotNull(groups = {CreatePostagem.class, UpdatePostagem.class})
    @NotEmpty(groups = {CreatePostagem.class, UpdatePostagem.class})
    private String conteudo;

    @Column(name = "data", nullable = false, updatable = false)
    private LocalDate data;

    @Column(name = "tipo", nullable = false)
    @Enumerated(EnumType.STRING)
    @NotNull(groups = { CreatePostagem.class, UpdatePostagem.class })
    private TipoPostagem tipo;

    @ManyToOne()
    @JoinColumn(name = "disciplina", nullable = false, updatable = false)
    private Disciplina disciplina;

    @PrePersist
    public void prePersist() {
        this.data = LocalDate.now();
    }

}
