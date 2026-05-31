package com.ipn.mx.vendecercaapi.features.mail.controller;

import com.ipn.mx.vendecercaapi.features.mail.service.mailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/mails")
public class mailController {
    @Autowired
    private mailService mailService;

    @GetMapping
    public ResponseEntity<Map<String, String>> sendMail() {
        String to = "diego260506@icloud.com";
        String subject = "Prueba de correo VendeCerca";
        mailService.enviarCorreoEelectronico(to,
                subject,
                "Correo de prueba enviado desde la API VendeCerca.");
        return ResponseEntity.ok(Map.of(
                "mensaje", "Correo enviado correctamente",
                "destinatario", to,
                "asunto", subject
        ));
    }

    @PostMapping("/enviar")
    public ResponseEntity<Map<String, String>> sendMail(
            @RequestParam String to,
            @RequestParam(defaultValue = "Correo VendeCerca") String subject,
            @RequestParam(defaultValue = "Correo enviado desde la API VendeCerca.") String text) {
        mailService.enviarCorreoEelectronico(to, subject, text);
        return ResponseEntity.ok(Map.of(
                "mensaje", "Correo enviado correctamente",
                "destinatario", to,
                "asunto", subject
        ));
    }
}
