package com.biblioteca.prestamos.infraestructura.adaptadores;

import com.biblioteca.prestamos.dominio.RepositorioPrestamo;
import com.biblioteca.libros.dominio.Libro;
import com.biblioteca.libros.infraestructura.persistencia.LibroEntidad;
import com.biblioteca.libros.infraestructura.persistencia.RepositorioLibroJpa;
import com.biblioteca.prestamos.dominio.Prestamo;
import com.biblioteca.prestamos.infraestructura.persistencia.PrestamoEntidad;
import com.biblioteca.prestamos.infraestructura.persistencia.RepositorioPrestamoJpa;
import org.springframework.stereotype.Component;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class RepositorioPrestamoImpl implements RepositorioPrestamo {
    private final RepositorioPrestamoJpa repositorioJpa;
    private final RepositorioLibroJpa repositorioLibroJpa;

    public RepositorioPrestamoImpl(RepositorioPrestamoJpa repositorioJpa,
                                   RepositorioLibroJpa repositorioLibroJpa) {
        this.repositorioJpa = repositorioJpa;
        this.repositorioLibroJpa = repositorioLibroJpa;
    }

    @Override
    public Optional<Prestamo> obtenerPorId(Long id) {
        return repositorioJpa.findById(id).map(this::aDominio);
    }

    @Override
    public List<Prestamo> obtenerPorUsuario(Long idUsuario) {
        return repositorioJpa.findByIdUsuario(idUsuario).stream()
                .map(this::aDominio)
                .collect(Collectors.toList());
    }

    @Override
    public Prestamo guardar(Prestamo prestamo) {
        PrestamoEntidad entidad = aEntidad(prestamo);
        PrestamoEntidad entidadGuardada = repositorioJpa.save(entidad);
        return aDominio(entidadGuardada);
    }

    @Override
    public long contarTotalPrestamos() {
        return repositorioJpa.count();
    }

    @Override
    public List<Libro> obtenerLibrosMasPrestados(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        List<Object[]> resultados = repositorioJpa.obtenerLibrosMasPrestados(pageable);
        List<Libro> librosMasPrestados = resultados.stream()
            .map(resultado -> {
                Long idLibro = (Long) resultado[0];
                // Buscar el libro por idLibro
                LibroEntidad libroEntidad = repositorioLibroJpa.findById(idLibro)
                        .orElseThrow(() -> new RuntimeException("Libro no encontrado con id " + idLibro));
                // Convertir LibroEntidad a Libro
                Libro libro = aDominio(libroEntidad);
                return libro;
            })
            .collect(Collectors.toList());
        return librosMasPrestados;
    }

    // Métodos de mapeo
    private Prestamo aDominio(PrestamoEntidad entidad) {
        Prestamo prestamo = new Prestamo();
        prestamo.setId(entidad.getIdPrestamo());
        prestamo.setIdUsuario(entidad.getIdUsuario());
        prestamo.setIdLibro(entidad.getIdLibro());
        prestamo.setFechaInicio(entidad.getFechaInicio());
        prestamo.setFechaDevolucion(entidad.getFechaDevolucion());
        return prestamo;
    }

    private PrestamoEntidad aEntidad(Prestamo prestamo) {
        PrestamoEntidad entidad = new PrestamoEntidad();
        entidad.setIdPrestamo(prestamo.getId());
        entidad.setIdUsuario(prestamo.getIdUsuario());
        entidad.setIdLibro(prestamo.getIdLibro());
        entidad.setFechaInicio(prestamo.getFechaInicio());
        entidad.setFechaDevolucion(prestamo.getFechaDevolucion());
        return entidad;
    }

    // Método de mapeo para LibroEntidad
    private Libro aDominio(LibroEntidad entidad) {
        Libro libro = new Libro();
        libro.setId(entidad.getIdLibro());
        libro.setTitulo(entidad.getTitulo());
        libro.setAutor(entidad.getAutor());
        libro.setAñoPublicacion(entidad.getAñoPublicacion());
        libro.setEstado(Libro.Estado.valueOf(entidad.getEstado().name()));
        return libro;
    }
}
