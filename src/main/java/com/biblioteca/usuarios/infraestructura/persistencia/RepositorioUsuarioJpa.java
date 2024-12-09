package com.biblioteca.usuarios.infraestructura.persistencia;



import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RepositorioUsuarioJpa extends JpaRepository<UsuarioEntidad, Long> {
    Optional<UsuarioEntidad> findByEmail(String email);
}
