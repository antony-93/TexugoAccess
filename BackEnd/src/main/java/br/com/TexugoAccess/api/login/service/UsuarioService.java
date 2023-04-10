package br.com.TexugoAccess.api.login.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.TexugoAccess.api.login.model.Usuario;
import br.com.TexugoAccess.api.login.model.UsuarioRequest;
import br.com.TexugoAccess.api.repository.UsuarioNotFoundException;
import br.com.TexugoAccess.api.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    private UsuarioBuilder builder = new UsuarioBuilder();

    public Usuario findByEmail(String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        return usuarioOptional.orElseThrow(() -> new UsuarioNotFoundException("Usuario nao encontrado"));
    }

    public boolean deleteByEmail(String email) {
        if (usuarioRepository.existsByEmail(email)) {
            usuarioRepository.deleteByEmail(email);
            return true;
        }else{
            throw new UsuarioNotFoundException("Usuario nao encontrado");
        }
    }

    public Usuario createUsuario(UsuarioRequest usuarioRequest) {
        if (usuarioRepository.existsByEmail(usuarioRequest.getEmail())) {
            throw new UsuarioNotFoundException("Email já cadastrado");
        }
        Usuario usuario = builder.buildCreateUsuario(usuarioRequest);
        return usuarioRepository.save(usuario);
    }

    public Usuario updateUsuario(String email, UsuarioRequest usuarioRequest) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        if (!usuarioOptional.isPresent()) {
            throw new UsuarioNotFoundException("Usuario nao encontrado");
        }

        Usuario usuarioExistente = usuarioOptional.get();

        if (usuarioRequest.getSenha() != null) {
            usuarioExistente.setSenha(usuarioRequest.getSenha());
        }
        if (usuarioRequest.getVerificado() != null) {
            usuarioExistente.setVerificado(usuarioRequest.getVerificado());
        }
        return usuarioRepository.save(usuarioExistente);
    }

}
