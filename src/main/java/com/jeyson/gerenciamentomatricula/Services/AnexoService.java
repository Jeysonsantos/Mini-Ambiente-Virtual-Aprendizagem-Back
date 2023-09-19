package com.jeyson.gerenciamentomatricula.Services;

import java.sql.Blob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jeyson.gerenciamentomatricula.Repositories.AnexoRepository;

@Service
public class AnexoService {
    
    @Autowired
    private AnexoRepository anexoRepository;

    public Blob getDadosById(Long id_anexo) {
        return this.anexoRepository.getDadosById_anexo(id_anexo);
    }

    
}
