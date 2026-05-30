package com.ipn.mx.vendecercaapi.features.tipoProducto.service.impl;

import com.ipn.mx.vendecercaapi.entidades.TipoProducto;
import com.ipn.mx.vendecercaapi.features.tipoProducto.repository.TipoProductoRepository;
import com.ipn.mx.vendecercaapi.features.tipoProducto.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TipoProductoServiceImpl implements TipoProductoService {
    @Autowired
    private TipoProductoRepository tipoProductoRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoProducto> findAll() {
        return tipoProductoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public TipoProducto findById(Long id) {
        return tipoProductoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public TipoProducto save(TipoProducto tipoProducto) {
        return tipoProductoRepository.save(tipoProducto);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        tipoProductoRepository.deleteById(id);
    }
}
