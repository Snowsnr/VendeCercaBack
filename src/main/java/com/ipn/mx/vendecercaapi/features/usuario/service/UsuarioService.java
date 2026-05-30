package com.ipn.mx.vendecercaapi.features.usuario.service;

import com.ipn.mx.vendecercaapi.entidades.Usuario;

import java.util.List;

public interface UsuarioService {
    public List<Usuario> findAll();
    public Usuario findById(Long id);
    public Usuario save(Usuario usuario);
    public void deleteById(Long id);
}
