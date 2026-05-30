package com.ipn.mx.vendecercaapi.features.imagen.service;

import com.ipn.mx.vendecercaapi.entidades.Imagen;

import java.util.List;

public interface ImagenService {
    public List<Imagen> findAll();
    public Imagen findById(Long id);
    public Imagen save(Imagen imagen);
    public void deleteById(Long id);
}
