package com.ipn.mx.vendecercaapi.features.persona.service;

import com.ipn.mx.vendecercaapi.entidades.Persona;

import java.util.List;

public interface PersonaService {
    public List<Persona> findAll();
    public Persona findById(Long id);
    public Persona save(Persona persona);
    public void deleteById(Long id);
}
