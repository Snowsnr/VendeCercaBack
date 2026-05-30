package com.ipn.mx.vendecercaapi.features.imagen.service.impl;

import com.ipn.mx.vendecercaapi.entidades.Imagen;
import com.ipn.mx.vendecercaapi.features.imagen.repository.ImagenRepository;
import com.ipn.mx.vendecercaapi.features.imagen.service.ImagenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImagenServiceImpl implements ImagenService {
    @Autowired
    private ImagenRepository imagenRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Imagen> findAll() {
        return imagenRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Imagen findById(Long id) {
        return imagenRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Imagen save(Imagen imagen) {
        return imagenRepository.save(imagen);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        imagenRepository.deleteById(id);
    }
}
