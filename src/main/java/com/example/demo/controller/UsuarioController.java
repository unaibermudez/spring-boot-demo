package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Get all users
    @GetMapping
    public List<Usuario> getAllUsuarios() {
        return usuarioRepository.findAll();
    }

    // Get user by id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable Long id) {
        return usuarioRepository.findById(id)
                .map(usuario -> ResponseEntity.ok().body(usuario))
                .orElse(ResponseEntity.notFound().build());
    }

    // Create a new user
    @PostMapping
    public Usuario createUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Update an existing user
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable Long id, @RequestBody Usuario usuarioDetails) {
        return usuarioRepository.findById(id)
                .map(usuario -> {
                    usuario.setName(usuarioDetails.getName());
                    usuario.setEmail(usuarioDetails.getEmail());
                    return ResponseEntity.ok(usuarioRepository.save(usuario));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Delete a user
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUsuario(@PathVariable Long id) {
        return usuarioRepository.findById(id)
            .map(usuario -> {
                usuarioRepository.delete(usuario);
                return ResponseEntity.ok().body("{\"message\": \"user deleted\"}");
            })
            .orElse(ResponseEntity.notFound().build());
    }

}
