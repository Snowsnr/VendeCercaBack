package com.ipn.mx.vendecercaapi.features.imagen.controller;

import com.ipn.mx.vendecercaapi.entidades.Imagen;
import com.ipn.mx.vendecercaapi.features.imagen.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/imagenes")
public class ImagenController {
    @Autowired
    private ImagenService imagenService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Imagen> findAll() {
        return imagenService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Imagen findById(@PathVariable Long id) {
        return imagenService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Imagen create(@RequestBody Imagen imagen) {
        return imagenService.save(imagen);
    }

    @PutMapping("/{id}")
    public Imagen update(@PathVariable Long id, @RequestBody Imagen imagen) {
        Imagen i = imagenService.findById(id);
        i.setNegId(imagen.getNegId());
        i.setPerId(imagen.getPerId());
        i.setProId(imagen.getProId());
        i.setImgUrl(imagen.getImgUrl());
        i.setImgPrincipal(imagen.getImgPrincipal());
        return imagenService.save(i);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        imagenService.deleteById(id);
    }
}
