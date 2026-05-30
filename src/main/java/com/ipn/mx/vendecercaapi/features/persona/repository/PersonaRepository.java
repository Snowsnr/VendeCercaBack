package com.ipn.mx.vendecercaapi.features.persona.repository;

import com.ipn.mx.vendecercaapi.entidades.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
