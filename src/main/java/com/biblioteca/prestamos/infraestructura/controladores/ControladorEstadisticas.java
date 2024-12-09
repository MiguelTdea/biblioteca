package com.biblioteca.prestamos.infraestructura.controladores;


import com.biblioteca.prestamos.aplicacion.ServicioPrestamo;
import com.biblioteca.libros.dominio.Libro;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/estadisticas")
public class ControladorEstadisticas {

    private final ServicioPrestamo servicioPrestamo;

    public ControladorEstadisticas(ServicioPrestamo servicioPrestamo) {
        this.servicioPrestamo = servicioPrestamo;
    }

    @GetMapping("/prestamos/total")
    public long obtenerNumeroTotalPrestamos() {
        return servicioPrestamo.obtenerNumeroTotalPrestamos();
    }

    @GetMapping("/prestamos/libros-mas-prestados")
    public List<Libro> obtenerLibrosMasPrestados(@RequestParam(defaultValue = "5") int limit) {
        return servicioPrestamo.obtenerLibrosMasPrestados(limit);
    }

    @GetMapping("/prestamos")
    public Map<String, Object> obtenerEstadisticasPrestamos() {
        return servicioPrestamo.obtenerEstadisticasPrestamos();
    }
}
