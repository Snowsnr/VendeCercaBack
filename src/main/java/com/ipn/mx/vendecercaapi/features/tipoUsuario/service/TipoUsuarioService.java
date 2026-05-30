package com.ipn.mx.vendecercaapi.features.tipoUsuario.service;

import com.ipn.mx.vendecercaapi.entidades.TipoUsuario;

import java.util.List;

public interface TipoUsuarioService {
    public List<TipoUsuario> findAll();
    public TipoUsuario findById(Long id);
    public TipoUsuario save(TipoUsuario tipoUsuario);
    public void deleteById(Long id);
}
