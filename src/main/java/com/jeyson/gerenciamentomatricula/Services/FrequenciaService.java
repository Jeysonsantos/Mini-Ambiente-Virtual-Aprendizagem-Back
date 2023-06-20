package com.jeyson.gerenciamentomatricula.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeyson.gerenciamentomatricula.Models.Frequencia;
import com.jeyson.gerenciamentomatricula.Repositories.FrequenciaRepository;

@Service
public class FrequenciaService {

    @Autowired
    private FrequenciaRepository frequenciaRepository;

    @Transactional
    public Frequencia createFrequencia(Frequencia frequencia) {
        frequencia.setId_frequencia(null);
        frequencia = this.frequenciaRepository.save(frequencia);
        return frequencia;
    }

}
