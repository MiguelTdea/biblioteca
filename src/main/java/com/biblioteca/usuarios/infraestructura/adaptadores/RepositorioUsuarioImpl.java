package com.biblioteca.usuarios.infraestructura.adaptadores;



import com.biblioteca.usuarios.dominio.Usuario;
import com.biblioteca.usuarios.dominio.RepositorioUsuario;
import com.biblioteca.usuarios.infraestructura.persistencia.RepositorioUsuarioJpa;
import com.biblioteca.usuarios.infraestructura.persistencia.UsuarioEntidad;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RepositorioUsuarioImpl implements RepositorioUsuario {

    private final RepositorioUsuarioJpa repositorioJpa;

    public RepositorioUsuarioImpl(RepositorioUsuarioJpa repositorioJpa) {
        this.repositorioJpa = repositorioJpa;
    }

    @Override
    public Optional<Usuario> obtenerPorId(Long id) {
        return repositorioJpa.findById(id).map(this::aDominio);
    }

    

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntidad entidad = aEntidad(usuario);
        UsuarioEntidad entidadGuardada = repositorioJpa.save(entidad);
        return aDominio(entidadGuardada);
    }

    // Métodos de mapeo
    private Usuario aDominio(UsuarioEntidad entidad) {
        Usuario usuario = new Usuario();
        usuario.setId(entidad.getIdUsuario());
        usuario.setNombre(entidad.getNombre());
        usuario.setApellido(entidad.getApellido());
        usuario.setEmail(entidad.getEmail());
        usuario.setContraseña(entidad.getContraseña());
        usuario.setRol(Usuario.Rol.valueOf(entidad.getRol().name()));
        return usuario;
    }

    private UsuarioEntidad aEntidad(Usuario usuario) {
        UsuarioEntidad entidad = new UsuarioEntidad();
        entidad.setIdUsuario(usuario.getId());
        entidad.setNombre(usuario.getNombre());
        entidad.setApellido(usuario.getApellido());
        entidad.setEmail(usuario.getEmail());
        entidad.setContraseña(usuario.getContraseña());
        entidad.setRol(UsuarioEntidad.Rol.valueOf(usuario.getRol().name()));
        return entidad;
    }
}
