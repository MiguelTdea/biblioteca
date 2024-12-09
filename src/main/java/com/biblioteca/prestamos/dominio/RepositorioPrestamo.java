package com.biblioteca.prestamos.dominio;


import java.util.List;
import java.util.Optional;

import com.biblioteca.libros.dominio.Libro;

public interface RepositorioPrestamo {
    Optional<Prestamo> obtenerPorId(Long id);
    List<Prestamo> obtenerPorUsuario(Long idUsuario);
    Prestamo guardar(Prestamo prestamo);
     long contarTotalPrestamos();
    List<Libro> obtenerLibrosMasPrestados(int limit);
}
