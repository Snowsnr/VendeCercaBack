package com.ipn.mx.vendecercaapi.features.productoServicio.controller;

import com.ipn.mx.vendecercaapi.entidades.ProductoServicio;
import com.ipn.mx.vendecercaapi.features.productoServicio.service.ProductoServicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos-servicios")
public class ProductoServicioController {
    @Autowired
    private ProductoServicioService productoServicioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductoServicio> findAll() {
        return productoServicioService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductoServicio findById(@PathVariable Long id) {
        return productoServicioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoServicio create(@RequestBody ProductoServicio productoServicio) {
        return productoServicioService.save(productoServicio);
    }

    @PutMapping("/{id}")
    public ProductoServicio update(@PathVariable Long id, @RequestBody ProductoServicio productoServicio) {
        ProductoServicio p = productoServicioService.findById(id);
        p.setNegId(productoServicio.getNegId());
        p.setProNombre(productoServicio.getProNombre());
        p.setProDescripcion(productoServicio.getProDescripcion());
        p.setProFecha(productoServicio.getProFecha());
        p.setProActivo(productoServicio.getProActivo());
        p.setProPrecio(productoServicio.getProPrecio());
        p.setTprId(productoServicio.getTprId());
        p.setProCantidad(productoServicio.getProCantidad());
        p.setImagen(productoServicio.getImagen());
        return productoServicioService.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productoServicioService.deleteById(id);
    }
}
