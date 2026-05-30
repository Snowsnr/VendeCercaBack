package com.ipn.mx.vendecercaapi.features.productoServicio.service.impl;

import com.ipn.mx.vendecercaapi.entidades.ProductoServicio;
import com.ipn.mx.vendecercaapi.features.productoServicio.repository.ProductoServicioRepository;
import com.ipn.mx.vendecercaapi.features.productoServicio.service.ProductoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductoServicioServiceImpl implements ProductoServicioService {
    @Autowired
    private ProductoServicioRepository productoServicioRepository;

    @Override
    @Transactional(readOnly = true)
    public List<ProductoServicio> findAll() {
        return productoServicioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoServicio findById(Long id) {
        return productoServicioRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public ProductoServicio save(ProductoServicio productoServicio) {
        return productoServicioRepository.save(productoServicio);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        productoServicioRepository.deleteById(id);
    }
}
