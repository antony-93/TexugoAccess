package br.com.TexugoAccess.BackEnd.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.TexugoAccess.BackEnd.UsuarioNotFoundException;
import br.com.TexugoAccess.BackEnd.login.model.Usuario;
import br.com.TexugoAccess.BackEnd.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario findByEmail(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        if (!usuarioOptional.isPresent()) {
            throw new UsuarioNotFoundException("Usuário não encontrado");
        }
        return usuarioOptional.get();
    }

    public void deleteByEmail(String email) {
        usuarioRepository.deleteByEmail(email);
    }
}

