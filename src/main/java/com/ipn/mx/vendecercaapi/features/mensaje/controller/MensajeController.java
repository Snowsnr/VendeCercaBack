package com.ipn.mx.vendecercaapi.features.mensaje.controller;

import com.ipn.mx.vendecercaapi.entidades.Mensaje;
import com.ipn.mx.vendecercaapi.features.mensaje.service.MensajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mensajes")
public class MensajeController {
    @Autowired
    private MensajeService mensajeService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Mensaje> findAll() {
        return mensajeService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Mensaje findById(@PathVariable Long id) {
        return mensajeService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mensaje create(@RequestBody Mensaje mensaje) {
        return mensajeService.save(mensaje);
    }

    @PutMapping("/{id}")
    public Mensaje update(@PathVariable Long id, @RequestBody Mensaje mensaje) {
        Mensaje m = mensajeService.findById(id);
        m.setMenTexto(mensaje.getMenTexto());
        m.setMenFecha(mensaje.getMenFecha());
        m.setMenLeido(mensaje.getMenLeido());
        m.setPerIdEmisor(mensaje.getPerIdEmisor());
        m.setChaId(mensaje.getChaId());
        return mensajeService.save(m);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        mensajeService.deleteById(id);
    }
}
