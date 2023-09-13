package com.jeyson.gerenciamentomatricula.Services.ProfessorServicee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.Anexo;
import com.jeyson.gerenciamentomatricula.Models.Atividade;
import com.jeyson.gerenciamentomatricula.Models.Postagem;
import com.jeyson.gerenciamentomatricula.Repositories.AnexoRepository;
import com.jeyson.gerenciamentomatricula.Repositories.AtividadeRepository;
import com.jeyson.gerenciamentomatricula.Repositories.PostagemRepository;
import com.jeyson.gerenciamentomatricula.Repositories.ProfessorRepository;



@Service
public class ProfessorService {

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private AnexoRepository anexoRepository;

    @Transactional
    public Postagem createPostagem(Postagem postagem){
        postagem.setId_postagem(null);

        postagem = this.postagemRepository.save(postagem);

        return postagem;
    }

    @Transactional
    public Atividade createAtividade(Atividade atividade){
        atividade.setId_atividade(null);

        atividade = this.atividadeRepository.save(atividade);

        return atividade;
    }

    @Transactional
    public Anexo createAnexo(Anexo anexo){
        anexo.setId_anexo(null);

        anexo = this.anexoRepository.save(anexo);

        return anexo;
    }
    
}
