package com.biblioteca.libros.infraestructura.adaptadores;


import com.biblioteca.libros.dominio.Libro;
import com.biblioteca.libros.dominio.RepositorioLibro;
import com.biblioteca.libros.infraestructura.persistencia.LibroEntidad;
import com.biblioteca.libros.infraestructura.persistencia.RepositorioLibroJpa;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RepositorioLibroImpl implements RepositorioLibro {

    private final RepositorioLibroJpa repositorioJpa;

    public RepositorioLibroImpl(RepositorioLibroJpa repositorioJpa) {
        this.repositorioJpa = repositorioJpa;
    }

    @Override
    public Optional<Libro> obtenerPorId(Long id) {
        return repositorioJpa.findById(id).map(this::aDominio);
    }

    @Override
    public List<Libro> obtenerTodos() {
        return repositorioJpa.findAll().stream()
                .map(this::aDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Libro guardar(Libro libro) {
        LibroEntidad entidad = aEntidad(libro);
        LibroEntidad entidadGuardada = repositorioJpa.save(entidad);
        return aDominio(entidadGuardada);
    }

    @Override
    public void eliminar(Long id) {
        repositorioJpa.deleteById(id);
    }

    @Override
    public Libro editar(Libro libro, Long id) {
        Optional<LibroEntidad> entidadExistenteOpt = repositorioJpa.findById(id);
        if (entidadExistenteOpt.isPresent()) {
            LibroEntidad entidadExistente = entidadExistenteOpt.get();
            // Actualizar los campos necesarios
            entidadExistente.setTitulo(libro.getTitulo());
            entidadExistente.setAutor(libro.getAutor());
            entidadExistente.setAñoPublicacion(libro.getAñoPublicacion());
            entidadExistente.setEstado(LibroEntidad.Estado.valueOf(libro.getEstado().name()));
            // Guardar la entidad actualizada
            LibroEntidad entidadGuardada = repositorioJpa.save(entidadExistente);
            return aDominio(entidadGuardada);
        } else {
            // Manejar el caso donde el libro no existe
            throw new RuntimeException("Libro no encontrado con id " + id);
        }
    }

    // Métodos de mapeo
    private Libro aDominio(LibroEntidad entidad) {
        Libro libro = new Libro();
        libro.setId(entidad.getIdLibro());
        libro.setTitulo(entidad.getTitulo());
        libro.setAutor(entidad.getAutor());
        libro.setAñoPublicacion(entidad.getAñoPublicacion());
        libro.setEstado(Libro.Estado.valueOf(entidad.getEstado().name()));
        return libro;
    }

    private LibroEntidad aEntidad(Libro libro) {
        LibroEntidad entidad = new LibroEntidad();
        entidad.setIdLibro(libro.getId());
        entidad.setTitulo(libro.getTitulo());
        entidad.setAutor(libro.getAutor());
        entidad.setAñoPublicacion(libro.getAñoPublicacion());
        entidad.setEstado(LibroEntidad.Estado.valueOf(libro.getEstado().name()));
        return entidad;
    }
}

