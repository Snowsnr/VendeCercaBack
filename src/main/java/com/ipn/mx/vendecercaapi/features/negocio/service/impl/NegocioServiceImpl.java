package com.ipn.mx.vendecercaapi.features.negocio.service.impl;

import com.ipn.mx.vendecercaapi.entidades.Negocio;
import com.ipn.mx.vendecercaapi.features.negocio.repository.NegocioRepository;
import com.ipn.mx.vendecercaapi.features.negocio.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NegocioServiceImpl implements NegocioService {
    @Autowired
    private NegocioRepository negocioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Negocio> findAll() {
        return negocioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Negocio findById(Long id) {
        return negocioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Negocio save(Negocio negocio) {
        return negocioRepository.save(negocio);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        negocioRepository.deleteById(id);
    }
}
