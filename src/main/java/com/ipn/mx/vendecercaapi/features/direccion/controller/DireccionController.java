package com.ipn.mx.vendecercaapi.features.direccion.controller;


import com.ipn.mx.vendecercaapi.entidades.Direccion;
import com.ipn.mx.vendecercaapi.features.direccion.service.DireccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/direcciones")

public class DireccionController {
    @Autowired
    private DireccionService direccionService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Direccion> findAll() {
        return direccionService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Direccion findById(@PathVariable Long id) {
        return direccionService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Direccion create(@RequestBody Direccion direccion){
        return direccionService.save(direccion);
    }

    @PutMapping("/{id}")
    public Direccion update(@PathVariable Long id,
                           @RequestBody Direccion direccion){
        Direccion d = direccionService.findById(id);
        //hacer validaciones para null
        d.setDirCalle(direccion.getDirCalle());
        d.setDirColonia(direccion.getDirColonia());
        d.setDirCp(direccion.getDirCp());
        d.setDirLatitud(direccion.getDirLatitud());
        d.setDirLongitud(direccion.getDirLongitud());
        d.setDirIndicaciones(direccion.getDirIndicaciones());
        d.setDirUltimaUbicacion(direccion.getDirUltimaUbicacion());
        d.setDirNumero(direccion.getDirNumero());

        return direccionService.save(d);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id){
        direccionService.deleteById(id);
    }

}
