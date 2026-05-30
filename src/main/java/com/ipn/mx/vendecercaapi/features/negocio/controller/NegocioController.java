package com.ipn.mx.vendecercaapi.features.negocio.controller;

import com.ipn.mx.vendecercaapi.entidades.Negocio;
import com.ipn.mx.vendecercaapi.features.negocio.service.NegocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/negocios")
public class NegocioController {
    @Autowired
    private NegocioService negocioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Negocio> findAll() {
        return negocioService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Negocio findById(@PathVariable Long id) {
        return negocioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Negocio create(@RequestBody Negocio negocio) {
        return negocioService.save(negocio);
    }

    @PutMapping("/{id}")
    public Negocio update(@PathVariable Long id, @RequestBody Negocio negocio) {
        Negocio n = negocioService.findById(id);
        n.setNegNombre(negocio.getNegNombre());
        n.setNegDescripcion(negocio.getNegDescripcion());
        n.setNegFecha(negocio.getNegFecha());
        n.setNegActivo(negocio.getNegActivo());
        n.setNegAmbulante(negocio.getNegAmbulante());
        n.setNegAbierto(negocio.getNegAbierto());
        n.setImagenes(negocio.getImagenes());
        n.setPerId(negocio.getPerId());
        n.setDirId(negocio.getDirId());
        n.setProductoServicios(negocio.getProductoServicios());
        n.setFeedbacks(negocio.getFeedbacks());
        n.setChats(negocio.getChats());
        return negocioService.save(n);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        negocioService.deleteById(id);
    }
}
