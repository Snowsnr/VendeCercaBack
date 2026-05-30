package com.ipn.mx.vendecercaapi.features.negocio.service;

import com.ipn.mx.vendecercaapi.entidades.Negocio;

import java.util.List;

public interface NegocioService {
    public List<Negocio> findAll();
    public Negocio findById(Long id);
    public Negocio save(Negocio negocio);
    public void deleteById(Long id);
}
