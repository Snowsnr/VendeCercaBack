package com.ipn.mx.vendecercaapi.features.direccion.service;

import com.ipn.mx.vendecercaapi.entidades.Direccion;

import java.util.List;

public interface DireccionService {
    public List<Direccion> findAll();
    public Direccion findById(Long id);
    public Direccion save(Direccion direccion);
    public void deleteById(Long id);
}
