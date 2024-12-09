package com.biblioteca.usuarios.dominio;



public class Usuario {
    private Long id;
    private String nombre;
    private String apellido;
    private String email;
    private String contraseña;
    private Rol rol;

    public enum Rol {
        USUARIO,
        ADMINISTRADOR
    }

    // Constructores
    public Usuario() {}

    public Usuario(Long id, String nombre, String apellido, String email, String contraseña, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    

    // Getters
    public Long getId() { return id; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getContraseña() { return contraseña; }
    public Rol getRol() { return rol; }

    // Setters
    public void setId(Long id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public void setRol(Rol rol) { this.rol = rol; }
}

