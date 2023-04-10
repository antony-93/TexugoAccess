package br.com.TexugoAccess.api.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.TexugoAccess.api.login.model.Usuario;

//Configurção para permitir encontrar e deletar o usuario por email
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 
    Optional<Usuario> findByEmail(String email);
    void deleteByEmail(String email);
    boolean existsByEmail(String email);
}
    
