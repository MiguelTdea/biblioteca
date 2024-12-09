package com.biblioteca.usuarios.dominio;




import java.util.Optional;

public interface RepositorioUsuario {
    Optional<Usuario> obtenerPorId(Long id);
    Usuario guardar(Usuario usuario);
    
}

