package com.ipn.mx.vendecercaapi.features.tipoUsuario.service.impl;

import com.ipn.mx.vendecercaapi.entidades.TipoUsuario;
import com.ipn.mx.vendecercaapi.features.tipoUsuario.repository.TipoUsuarioRepository;
import com.ipn.mx.vendecercaapi.features.tipoUsuario.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoUsuarioServiceImpl implements TipoUsuarioService {
    @Autowired
    private TipoUsuarioRepository tipoUsuarioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoUsuario> findAll() {
        return tipoUsuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoUsuario findById(Long id) {
        return tipoUsuarioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TipoUsuario save(TipoUsuario tipoUsuario) {
        return tipoUsuarioRepository.save(tipoUsuario);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tipoUsuarioRepository.deleteById(id);
    }
}
