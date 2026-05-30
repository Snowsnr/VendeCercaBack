package com.ipn.mx.vendecercaapi.features.productoServicio.service;

import com.ipn.mx.vendecercaapi.entidades.ProductoServicio;

import java.util.List;

public interface ProductoServicioService {
    public List<ProductoServicio> findAll();
    public ProductoServicio findById(Long id);
    public ProductoServicio save(ProductoServicio productoServicio);
    public void deleteById(Long id);
}
