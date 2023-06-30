package com.jeyson.gerenciamentomatricula.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Login {
    
    private String usuario;

    private String senha;
}
