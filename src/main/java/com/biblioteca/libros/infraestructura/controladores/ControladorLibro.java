package com.biblioteca.libros.infraestructura.controladores;


import com.biblioteca.libros.aplicacion.ServicioLibro;
import com.biblioteca.libros.dominio.Libro;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class ControladorLibro {

    private final ServicioLibro servicioLibro;

    public ControladorLibro(ServicioLibro servicioLibro) {
        this.servicioLibro = servicioLibro;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodosLosLibros() {
        List<Libro> libros = servicioLibro.obtenerTodosLosLibros();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        Libro libro = servicioLibro.obtenerPorId(id);
        return ResponseEntity.ok(libro);
    }

    @PostMapping("/agregar")
    public ResponseEntity<Libro> agregarLibro(@RequestBody Libro libro) {
        Libro libroAgregado = servicioLibro.agregarLibro(libro);
        return ResponseEntity.ok(libroAgregado);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        servicioLibro.eliminarLibro(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Libro> editarLibro(@RequestBody Libro libro, @PathVariable Long id) {
        Libro libroEditado = servicioLibro.editarLibro(libro, id);
        return ResponseEntity.ok(libroEditado);
    }

    

    
}
