package com.jeyson.gerenciamentomatricula.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = Anexo.TABLE_NAME)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Anexo {

    public static final String TABLE_NAME = "Anexos";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anexo", unique = true, nullable = false, updatable = false)
    private Long id_anexo;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "url", length = 255)
    private String url;

    private byte[] arquivo;

    private Long id_postagem;

    private Long id_atividade;

}
