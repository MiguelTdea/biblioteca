package com.biblioteca.prestamos.infraestructura.persistencia;


import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Prestamos")
public class PrestamoEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrestamo;

    private Long idUsuario;
    private Long idLibro;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    // Constructores
    public PrestamoEntidad() {}

    public PrestamoEntidad(Long idPrestamo, Long idUsuario, Long idLibro, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        this.idPrestamo = idPrestamo;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }

    

    // Getters
    public Long getIdPrestamo() { return idPrestamo; }
    public Long getIdUsuario() { return idUsuario; }
    public Long getIdLibro() { return idLibro; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    // Setters
    public void setIdPrestamo(Long idPrestamo) { this.idPrestamo = idPrestamo; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public void setIdLibro(Long idLibro) { this.idLibro = idLibro; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
}
