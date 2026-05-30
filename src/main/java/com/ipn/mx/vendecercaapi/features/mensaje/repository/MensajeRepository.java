package com.ipn.mx.vendecercaapi.features.mensaje.repository;

import com.ipn.mx.vendecercaapi.entidades.Mensaje;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MensajeRepository extends JpaRepository<Mensaje, Long> {
}
