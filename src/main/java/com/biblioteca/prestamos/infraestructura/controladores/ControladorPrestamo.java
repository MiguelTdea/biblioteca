package com.biblioteca.prestamos.infraestructura.controladores;


import com.biblioteca.prestamos.aplicacion.ServicioPrestamo;
import com.biblioteca.prestamos.dominio.Prestamo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/prestamos")
public class ControladorPrestamo {

    private final ServicioPrestamo servicioPrestamo;

    public ControladorPrestamo(ServicioPrestamo servicioPrestamo) {
        this.servicioPrestamo = servicioPrestamo;
    }

    @PostMapping("/realizar")
    public ResponseEntity<Prestamo> realizarPrestamo(@RequestParam Long idUsuario, @RequestParam Long idLibro) {
        Prestamo prestamo = servicioPrestamo.realizarPrestamo(idUsuario, idLibro);
        return ResponseEntity.ok(prestamo);
    }

    @PostMapping("/devolver/{idPrestamo}")
    public ResponseEntity<Prestamo> devolverPrestamo(@PathVariable Long idPrestamo) {
        Prestamo prestamo = servicioPrestamo.devolverPrestamo(idPrestamo);
        return ResponseEntity.ok(prestamo);
    }

   
}

