package br.com.TexugoAccess.BackEnd.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.TexugoAccess.BackEnd.login.model.Usuario;

//Configurção para permitir encontrar e deletar o usuario por email
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> { 
    Optional<Usuario> findByEmail(String email);
    void deleteByEmail(String email);
}
    
