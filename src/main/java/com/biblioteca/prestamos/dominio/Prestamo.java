package com.biblioteca.prestamos.dominio;


import java.time.LocalDate;

public class Prestamo {
    private Long id;
    private Long idUsuario;
    private Long idLibro;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    // Constructores
    public Prestamo() {}

    public Prestamo(Long id, Long idUsuario, Long idLibro, LocalDate fechaInicio, LocalDate fechaDevolucion) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.idLibro = idLibro;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = fechaDevolucion;
    }

    

    // Getters
    public Long getId() { return id; }
    public Long getIdUsuario() { return idUsuario; }
    public Long getIdLibro() { return idLibro; }
    public LocalDate getFechaInicio() { return fechaInicio; }
    public LocalDate getFechaDevolucion() { return fechaDevolucion; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public void setIdLibro(Long idLibro) { this.idLibro = idLibro; }
    public void setFechaInicio(LocalDate fechaInicio) { this.fechaInicio = fechaInicio; }
    public void setFechaDevolucion(LocalDate fechaDevolucion) { this.fechaDevolucion = fechaDevolucion; }
}
