package com.jeyson.gerenciamentomatricula.Models;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
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

    public static final String TABLE_NAME = "Anexo";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_anexo", unique = true, nullable = false, updatable = false)
    private Long id_anexo;

    @Column(name = "nome", nullable = false, length = 255)
    private String nome;

    @Column(name = "url", length = 255, nullable = true)
    private String url;

    @Column(name = "tipo", nullable = false, length = 255)
    private String tipo;

    @Lob
    @Column(name = "dados")
    private byte[] dados;

    private Long id_postagem;

    private Long id_atividade;

    private Long id_disciplina;

}
