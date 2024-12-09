package com.biblioteca.libros.dominio;


public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private int añoPublicacion;
    private Estado estado;

    public enum Estado {
        DISPONIBLE,
        PRESTADO
    }

    // Constructores
    public Libro() {}

    public Libro(Long id, String titulo, String autor, int añoPublicacion, Estado estado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.añoPublicacion = añoPublicacion;
        this.estado = estado;
    }

    

    // Getters
    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public int getAñoPublicacion() { return añoPublicacion; }
    public Estado getEstado() { return estado; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setAutor(String autor) { this.autor = autor; }
    public void setAñoPublicacion(int añoPublicacion) { this.añoPublicacion = añoPublicacion; }
    public void setEstado(Estado estado) { this.estado = estado; }
}
