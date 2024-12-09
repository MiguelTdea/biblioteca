package com.biblioteca.libros.infraestructura.persistencia;


import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorioLibroJpa extends JpaRepository<LibroEntidad, Long> {
}

