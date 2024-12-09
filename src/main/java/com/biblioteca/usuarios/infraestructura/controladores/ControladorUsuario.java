package com.biblioteca.usuarios.infraestructura.controladores;



import com.biblioteca.usuarios.aplicacion.ServicioUsuario;
import com.biblioteca.usuarios.dominio.Usuario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class ControladorUsuario {

    private final ServicioUsuario servicioUsuario;

    public ControladorUsuario(ServicioUsuario servicioUsuario) {
        this.servicioUsuario = servicioUsuario;
    }

    @PostMapping("/registrar")
    public ResponseEntity<Usuario> registrarUsuario(@RequestBody Usuario usuario) {
        Usuario usuarioRegistrado = servicioUsuario.registrarUsuario(usuario);
        return ResponseEntity.ok(usuarioRegistrado);
    }

    

    
}
