package com.biblioteca.libros.aplicacion;


import com.biblioteca.libros.dominio.Libro;
import com.biblioteca.libros.dominio.RepositorioLibro;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ServicioLibro {

    private final RepositorioLibro repositorioLibro;

    public ServicioLibro(RepositorioLibro repositorioLibro) {
        this.repositorioLibro = repositorioLibro;
    }

    public List<Libro> obtenerTodosLosLibros() {
        return repositorioLibro.obtenerTodos();
    }

    public Libro obtenerPorId(Long id) {
        return repositorioLibro.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));
    }

    public Libro agregarLibro(Libro libro) {
       
        return repositorioLibro.guardar(libro);
    }

    public void eliminarLibro(Long id) {
        repositorioLibro.eliminar(id);
    }

    public Libro editarLibro(Libro libro, Long id) {
       
        return repositorioLibro.editar(libro, id);
    }

  
}
