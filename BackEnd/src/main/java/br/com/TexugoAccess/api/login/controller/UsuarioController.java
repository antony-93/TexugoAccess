package br.com.TexugoAccess.api.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.TexugoAccess.api.login.model.Usuario;
import br.com.TexugoAccess.api.login.model.UsuarioRequest;
import br.com.TexugoAccess.api.login.service.UsuarioService;
import static br.com.TexugoAccess.api.ApiConstants.ROTA_USUARIO_EMAIL;
import static br.com.TexugoAccess.api.ApiConstants.ROTA_USUARIO_MAIN;

import javax.transaction.Transactional;

@RestController
@RequestMapping(ROTA_USUARIO_MAIN)
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping(ROTA_USUARIO_EMAIL)
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String email) {
        Usuario usuario = usuarioService.findByEmail(email);
        return ResponseEntity.ok(usuario);
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.createUsuario(usuarioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);
    }

    @PutMapping(ROTA_USUARIO_EMAIL)
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String email, @RequestBody UsuarioRequest usuarioRequest) {
        Usuario usuario = usuarioService.updateUsuario(email, usuarioRequest);
        return ResponseEntity.ok(usuario);
    }

    @Transactional
    @DeleteMapping(ROTA_USUARIO_EMAIL)
    public ResponseEntity<Void> deleteUsuario(@PathVariable String email) {
        usuarioService.deleteByEmail(email);
        return ResponseEntity.noContent().build();
    }

}
