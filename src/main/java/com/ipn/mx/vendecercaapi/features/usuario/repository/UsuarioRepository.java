package com.ipn.mx.vendecercaapi.features.usuario.repository;

import com.ipn.mx.vendecercaapi.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
