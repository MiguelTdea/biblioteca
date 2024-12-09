package com.biblioteca.usuarios.aplicacion;



import com.biblioteca.usuarios.dominio.Usuario;

import org.springframework.stereotype.Service;

import com.biblioteca.usuarios.dominio.RepositorioUsuario;

@Service
public class ServicioUsuario {

    private final RepositorioUsuario repositorioUsuario;

    public ServicioUsuario(RepositorioUsuario repositorioUsuario) {
        this.repositorioUsuario = repositorioUsuario;
    }

    public Usuario registrarUsuario(Usuario usuario) {
        
        return repositorioUsuario.guardar(usuario);
    }

    

   
}

