package com.ipn.mx.vendecercaapi.features.tipoProducto.controller;

import com.ipn.mx.vendecercaapi.entidades.TipoProducto;
import com.ipn.mx.vendecercaapi.features.tipoProducto.service.TipoProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipos-producto")
public class TipoProductoController {
    @Autowired
    private TipoProductoService tipoProductoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TipoProducto> findAll() {
        return tipoProductoService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TipoProducto findById(@PathVariable Long id) {
        return tipoProductoService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoProducto create(@RequestBody TipoProducto tipoProducto) {
        return tipoProductoService.save(tipoProducto);
    }

    @PutMapping("/{id}")
    public TipoProducto update(@PathVariable Long id, @RequestBody TipoProducto tipoProducto) {
        TipoProducto t = tipoProductoService.findById(id);
        t.setTprNombre(tipoProducto.getTprNombre());
        t.setProductos(tipoProducto.getProductos());
        return tipoProductoService.save(t);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tipoProductoService.deleteById(id);
    }
}
