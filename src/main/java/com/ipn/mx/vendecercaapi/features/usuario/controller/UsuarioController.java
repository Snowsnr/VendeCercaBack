package com.ipn.mx.vendecercaapi.features.usuario.controller;

import com.ipn.mx.vendecercaapi.entidades.Usuario;
import com.ipn.mx.vendecercaapi.features.usuario.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Usuario> findAll() {
        return usuarioService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario findById(@PathVariable Long id) {
        return usuarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario create(@RequestBody Usuario usuario) {
        return usuarioService.save(usuario);
    }

    @PutMapping("/{id}")
    public Usuario update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario u = usuarioService.findById(id);
        u.setUsuNombre(usuario.getUsuNombre());
        u.setUsuPassword(usuario.getUsuPassword());
        u.setUsuActivo(usuario.getUsuActivo());
        u.setTipId(usuario.getTipId());
        u.setPersona(usuario.getPersona());
        return usuarioService.save(u);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        usuarioService.deleteById(id);
    }
}
