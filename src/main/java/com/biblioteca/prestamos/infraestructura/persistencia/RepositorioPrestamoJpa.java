package com.biblioteca.prestamos.infraestructura.persistencia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RepositorioPrestamoJpa extends JpaRepository<PrestamoEntidad, Long> {
    List<PrestamoEntidad> findByIdUsuario(Long idUsuario);

    
    @Query("SELECT p.idLibro, COUNT(p.idLibro) as total FROM PrestamoEntidad p GROUP BY p.idLibro ORDER BY total DESC")
    List<Object[]> obtenerLibrosMasPrestados(Pageable pageable);
}
