package com.jeyson.gerenciamentomatricula.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeyson.gerenciamentomatricula.Models.AutenticarUsuario;
import com.jeyson.gerenciamentomatricula.Models.Login;
import com.jeyson.gerenciamentomatricula.Models.Usuario;
import com.jeyson.gerenciamentomatricula.Services.UsuarioService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {


    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody Login login) {
    AutenticarUsuario autenticarUsuario = new AutenticarUsuario();
    try {
        List<Usuario> usuarios = usuarioService.getAllUsuarios();
        String usuario = login.getUsuario();
        String senha = login.getSenha();
        
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(usuario) && u.getSenha().equals(senha)) {
                autenticarUsuario.setIdUsuario(u.getId_aluno_professor());
                autenticarUsuario.setTipoUsuario(u.getTipo_usuario());
                autenticarUsuario.setNome(u.getNome());
                return ResponseEntity.ok(autenticarUsuario);
            }
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}

}
