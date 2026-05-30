package com.ipn.mx.vendecercaapi.features.tipoProducto.service;

import com.ipn.mx.vendecercaapi.entidades.TipoProducto;

import java.util.List;

public interface TipoProductoService {
    public List<TipoProducto> findAll();
    public TipoProducto findById(Long id);
    public TipoProducto save(TipoProducto tipoProducto);
    public void deleteById(Long id);
}
