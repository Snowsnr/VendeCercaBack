package com.ipn.mx.vendecercaapi.features.direccion.service.impl;

import com.ipn.mx.vendecercaapi.entidades.Direccion;
import com.ipn.mx.vendecercaapi.features.direccion.repository.DireccionRepository;
import com.ipn.mx.vendecercaapi.features.direccion.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DireccionServiceImpl implements DireccionService {
    @Autowired
    private DireccionRepository direccionRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Direccion> findAll() {
        return direccionRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Direccion findById(Long id) {
        return direccionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Direccion save(Direccion direccion) {
        return direccionRepository.save(direccion);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        direccionRepository.deleteById(id);
    }

}
