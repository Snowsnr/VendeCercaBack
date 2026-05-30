package com.ipn.mx.vendecercaapi.features.mensaje.service.impl;

import com.ipn.mx.vendecercaapi.entidades.Mensaje;
import com.ipn.mx.vendecercaapi.features.mensaje.repository.MensajeRepository;
import com.ipn.mx.vendecercaapi.features.mensaje.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MensajeServiceImpl implements MensajeService {
    @Autowired
    private MensajeRepository mensajeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Mensaje> findAll() {
        return mensajeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Mensaje findById(Long id) {
        return mensajeRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Mensaje save(Mensaje mensaje) {
        return mensajeRepository.save(mensaje);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        mensajeRepository.deleteById(id);
    }
}
