package com.ipn.mx.vendecercaapi.features.archivo.service;

import com.ipn.mx.vendecercaapi.entidades.Archivo;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

public interface ArchivoService {
    Archivo guardarArchivoEnBaseDeDatos(MultipartFile archivo)
            throws IOException;
    Optional<Archivo> descargarArchivo(Long id) throws FileNotFoundException;
}
