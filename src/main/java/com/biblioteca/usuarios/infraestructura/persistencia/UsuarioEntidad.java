package com.biblioteca.usuarios.infraestructura.persistencia;



import jakarta.persistence.*;

@Entity
@Table(name = "Usuarios")
public class UsuarioEntidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nombre;
    private String apellido;
    
    @Column(unique = true, length = 191)
    private String email;
    private String contraseña;

    @Enumerated(EnumType.STRING)
    private Rol rol;

    public enum Rol {
        USUARIO,
        ADMINISTRADOR
    }

    // Constructores
    public UsuarioEntidad() {}

    public UsuarioEntidad(Long idUsuario, String nombre, String apellido, String email, String contraseña, Rol rol) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.contraseña = contraseña;
        this.rol = rol;
    }

    
    // Getters
    public Long getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
    public String getEmail() { return email; }
    public String getContraseña() { return contraseña; }
    public Rol getRol() { return rol; }

    // Setters
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public void setEmail(String email) { this.email = email; }
    public void setContraseña(String contraseña) { this.contraseña = contraseña; }
    public void setRol(Rol rol) { this.rol = rol; }
}
