package com.biblioteca.prestamos.aplicacion;


import com.biblioteca.prestamos.dominio.Prestamo;
import com.biblioteca.prestamos.dominio.RepositorioPrestamo;
import com.biblioteca.libros.dominio.RepositorioLibro;
import com.biblioteca.libros.dominio.Libro;


import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class ServicioPrestamo {

    private final RepositorioPrestamo repositorioPrestamo;
    private final RepositorioLibro repositorioLibro;

    public ServicioPrestamo(RepositorioPrestamo repositorioPrestamo, RepositorioLibro repositorioLibro) {
        this.repositorioPrestamo = repositorioPrestamo;
        this.repositorioLibro = repositorioLibro;
    }

    public Prestamo realizarPrestamo(Long idUsuario, Long idLibro) {
        Libro libro = repositorioLibro.obtenerPorId(idLibro)
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        if (libro.getEstado() == Libro.Estado.PRESTADO) {
            throw new RuntimeException("El libro no está disponible");
        }

        libro.setEstado(Libro.Estado.PRESTADO);
        repositorioLibro.guardar(libro);

        Prestamo prestamo = new Prestamo();
        prestamo.setIdUsuario(idUsuario);
        prestamo.setIdLibro(idLibro);
        prestamo.setFechaInicio(LocalDate.now());

        return repositorioPrestamo.guardar(prestamo);
    }

    public Prestamo devolverPrestamo(Long idPrestamo) {
        Prestamo prestamo = repositorioPrestamo.obtenerPorId(idPrestamo)
                .orElseThrow(() -> new RuntimeException("Préstamo no encontrado"));

        if (prestamo.getFechaDevolucion() != null) {
            throw new RuntimeException("El préstamo ya fue devuelto");
        }

        prestamo.setFechaDevolucion(LocalDate.now());
        repositorioPrestamo.guardar(prestamo);

        Libro libro = repositorioLibro.obtenerPorId(prestamo.getIdLibro())
                .orElseThrow(() -> new RuntimeException("Libro no encontrado"));

        libro.setEstado(Libro.Estado.DISPONIBLE);
        repositorioLibro.guardar(libro);

        return prestamo;
    }

     // Nuevo método para obtener el número total de préstamos
     public long obtenerNumeroTotalPrestamos() {
        return repositorioPrestamo.contarTotalPrestamos();
    }

    // Nuevo método para obtener los libros más prestados
    public List<Libro> obtenerLibrosMasPrestados(int limit) {
        return repositorioPrestamo.obtenerLibrosMasPrestados(limit);
    }

    
    public Map<String, Object> obtenerEstadisticasPrestamos() {
        long totalPrestamos = obtenerNumeroTotalPrestamos();
        List<Libro> librosMasPrestados = obtenerLibrosMasPrestados(5); // Obtener los 5 libros más prestados

        Map<String, Object> estadisticas = Map.of(
            "totalPrestamos", totalPrestamos,
            "librosMasPrestados", librosMasPrestados
        );

        return estadisticas;
    }

   
}
