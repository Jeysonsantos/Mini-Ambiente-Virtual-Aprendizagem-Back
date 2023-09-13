package com.jeyson.gerenciamentomatricula.Services.ProfessorServicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.Postagem;
import com.jeyson.gerenciamentomatricula.Repositories.PostagemRepository;
import com.jeyson.gerenciamentomatricula.Repositories.ProfessorRepository;



@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    @Transactional
    public Postagem createPostagem(Postagem postagem){
        postagem.setId_postagem(null);

        postagem = this.postagemRepository.save(postagem);

        return postagem;
    }
    
}
