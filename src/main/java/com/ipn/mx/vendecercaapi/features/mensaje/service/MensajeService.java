package com.ipn.mx.vendecercaapi.features.mensaje.service;

import com.ipn.mx.vendecercaapi.entidades.Mensaje;

import java.util.List;

public interface MensajeService {
    public List<Mensaje> findAll();
    public Mensaje findById(Long id);
    public Mensaje save(Mensaje mensaje);
    public void deleteById(Long id);
}
