package com.biblioteca.libros.dominio;


import java.util.List;
import java.util.Optional;

public interface RepositorioLibro {
    Optional<Libro> obtenerPorId(Long id);
    List<Libro> obtenerTodos();
    Libro guardar(Libro libro);
    void eliminar(Long id);
    Libro editar(Libro libro, Long id);
}
