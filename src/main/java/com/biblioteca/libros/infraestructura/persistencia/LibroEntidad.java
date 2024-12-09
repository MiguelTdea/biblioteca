package com.biblioteca.libros.infraestructura.persistencia;


import jakarta.persistence.*;

@Entity
@Table(name = "Libros")
public class LibroEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    private String titulo;
    private String autor;
    private int añoPublicacion;

    @Enumerated(EnumType.STRING)
    private Estado estado;

    public enum Estado {
        DISPONIBLE,
        PRESTADO
    }

    // Constructores
    public LibroEntidad() {}

    public LibroEntidad(Long idLibro, String titulo, String autor, int añoPublicacion, Estado estado) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.estado = estado;
    }

   
   

    // Getters
    public Long getIdLibro() { return idLibro; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAñoPublicacion() { return añoPublicacion; }
    public Estado getEstado() { return estado; }

    // Setters
    public void setIdLibro(Long idLibro) { this.idLibro = idLibro; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAñoPublicacion(int añoPublicacion) { this.añoPublicacion = añoPublicacion; }
    public void setEstado(Estado estado) { this.estado = estado; }
}

