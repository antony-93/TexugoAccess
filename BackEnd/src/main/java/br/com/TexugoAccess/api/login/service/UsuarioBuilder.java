package br.com.TexugoAccess.api.login.service;

import org.springframework.stereotype.Service;

import br.com.TexugoAccess.api.login.model.Usuario;
import br.com.TexugoAccess.api.login.model.UsuarioRequest;

@Service
public class UsuarioBuilder {
    
    public Usuario buildCreateUsuario(UsuarioRequest request) {
        return Usuario.builder()
                .email(request.getEmail())
                .nome(request.getNome())
                .telefone(request.getTelefone())
                .genero(request.getGenero())
                .senha(request.getSenha())
                .build();
                
    }
}
