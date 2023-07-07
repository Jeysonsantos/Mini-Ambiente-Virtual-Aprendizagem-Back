package com.jeyson.gerenciamentomatricula.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.jeyson.gerenciamentomatricula.Models.Usuario;
import com.jeyson.gerenciamentomatricula.Repositories.UsuarioRepository;

@Component
public class AdminUserInitializer implements CommandLineRunner {

    @Autowired
    private UsuarioRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        if (!userRepository.existsByCpf("admin")) {
            Usuario admin = new Usuario();
            admin.setCpf("admin");
            admin.setSenha("admin");
            admin.setId_aluno_professor(0L);
            admin.setTipo_usuario("Admin");
            admin.setNome("Administrador");

            userRepository.save(admin);
        }
    }
}
