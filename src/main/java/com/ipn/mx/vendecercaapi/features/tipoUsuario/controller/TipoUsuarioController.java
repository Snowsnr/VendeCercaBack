package com.ipn.mx.vendecercaapi.features.tipoUsuario.controller;

import com.ipn.mx.vendecercaapi.entidades.TipoUsuario;
import com.ipn.mx.vendecercaapi.features.tipoUsuario.service.TipoUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tipos-usuario")
public class TipoUsuarioController {
    @Autowired
    private TipoUsuarioService tipoUsuarioService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TipoUsuario> findAll() {
        return tipoUsuarioService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TipoUsuario findById(@PathVariable Long id) {
        return tipoUsuarioService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TipoUsuario create(@RequestBody TipoUsuario tipoUsuario) {
        return tipoUsuarioService.save(tipoUsuario);
    }

    @PutMapping("/{id}")
    public TipoUsuario update(@PathVariable Long id, @RequestBody TipoUsuario tipoUsuario) {
        TipoUsuario t = tipoUsuarioService.findById(id);
        t.setTipNombre(tipoUsuario.getTipNombre());
        t.setUsuarios(tipoUsuario.getUsuarios());
        return tipoUsuarioService.save(t);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        tipoUsuarioService.deleteById(id);
    }
}
