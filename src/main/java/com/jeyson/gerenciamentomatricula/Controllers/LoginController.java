package com.jeyson.gerenciamentomatricula.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jeyson.gerenciamentomatricula.Models.AutenticarUsuario;
import com.jeyson.gerenciamentomatricula.Models.Login;
import com.jeyson.gerenciamentomatricula.Services.AuthService;

@RestController
public class LoginController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> autenticar(@RequestBody Login login) {
        try {
            Long idUsuario = authService.obterIdUsuarioPorCpf(login.getUsuario());
            
            if (idUsuario != null) {
                AutenticarUsuario autenticarUsuario = new AutenticarUsuario();
                autenticarUsuario.setIdUsuario(idUsuario);
                autenticarUsuario.setTipoUsuario(authService.obterTipoUsuarioPorIdUsuario(idUsuario));
                if(login.getSenha().equals(authService.obterSenhaPorIdUsuario(idUsuario))) {
                    return ResponseEntity.ok(autenticarUsuario);
                } else {
                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
                }
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
