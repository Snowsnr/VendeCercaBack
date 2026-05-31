package com.ipn.mx.vendecercaapi.features.mail.service;

public interface mailService {
    void enviarCorreoEelectronico(String to, String subject, String text);
}
