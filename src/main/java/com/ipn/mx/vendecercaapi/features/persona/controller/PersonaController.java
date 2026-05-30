package com.ipn.mx.vendecercaapi.features.persona.controller;

import com.ipn.mx.vendecercaapi.entidades.Persona;
import com.ipn.mx.vendecercaapi.features.persona.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/personas")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Persona> findAll() {
        return personaService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Persona findById(@PathVariable Long id) {
        return personaService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Persona create(@RequestBody Persona persona) {
        return personaService.save(persona);
    }

    @PutMapping("/{id}")
    public Persona update(@PathVariable Long id, @RequestBody Persona persona) {
        Persona p = personaService.findById(id);
        p.setPerNombreCompleto(persona.getPerNombreCompleto());
        p.setPerTelefono(persona.getPerTelefono());
        p.setPerCorreo(persona.getPerCorreo());
        p.setPerFecha(persona.getPerFecha());
        p.setUsuId(persona.getUsuId());
        p.setChatsComoComprador(persona.getChatsComoComprador());
        p.setChatsComoVendedor(persona.getChatsComoVendedor());
        p.setNegocios(persona.getNegocios());
        p.setFeedbacks(persona.getFeedbacks());
        p.setImagen(persona.getImagen());
        return personaService.save(p);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        personaService.deleteById(id);
    }
}
