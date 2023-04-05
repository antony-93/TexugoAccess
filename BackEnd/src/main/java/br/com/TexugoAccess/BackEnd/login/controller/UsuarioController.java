package br.com.TexugoAccess.BackEnd.login.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.com.TexugoAccess.BackEnd.login.model.Usuario;
import br.com.TexugoAccess.BackEnd.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private static final String rota = "/email/{email}";
    private final UsuarioRepository repository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.repository = usuarioRepository;
    }

    //DEFINE O ENDPOINT PARA PEGAR UM USUARIO POR EMAIL
    @GetMapping(rota)
    public ResponseEntity<Usuario> findByEmail(@PathVariable String email) {
        return repository.findByEmail(email)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    //DEFINE O ENDPOINT PARA CADASTRAR UM USUARIO
    @PostMapping
    public Usuario create(@RequestBody Usuario usuario) {
        return repository.save(usuario);
    }

    //DEFINE O ENDPOINT PARA ALTERAR UM USUARIO POR EMAIL
    @PutMapping(rota)
    public ResponseEntity<Usuario> updateVerificado(@PathVariable String email, @RequestBody Usuario usuario) {
        return repository.findByEmail(email)
                .map(record -> {
                    if (usuario.getSenha() != null) {
                        record.setSenha(usuario.getSenha());
                    }
                    if(usuario.getVerificado() == true){
                        record.setVerificado(usuario.getVerificado());
                    }
                    Usuario updated = repository.save(record);
                    return ResponseEntity.ok().body(updated);
                }).orElse(ResponseEntity.notFound().build());
    }

    //DEFINE O ENDPOINT PARA DELETAR UM USUARIO POR EMAIL
    @DeleteMapping(rota)
    public ResponseEntity<?> delete(@PathVariable String email) {
        return repository.findByEmail(email)
                .map(record -> {
                    repository.deleteByEmail(email);
                    return ResponseEntity.ok().build();
                }).orElse(ResponseEntity.notFound().build());
    }
}
