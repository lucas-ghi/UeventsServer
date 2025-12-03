package com.ueventsserver.repository;

import com.ueventsserver.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNome(String nome);

    Optional<Usuario> findById(int id);
}
