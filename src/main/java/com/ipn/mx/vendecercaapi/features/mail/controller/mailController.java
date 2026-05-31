package com.ipn.mx.vendecercaapi.features.mail.controller;

import com.ipn.mx.vendecercaapi.features.mail.service.mailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/mails")
public class mailController {
    @Autowired
    private mailService mailService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void sendMail() {
        mailService.enviarCorreoEelectronico("diego260506@icloud.com",
                "Hola",
                "Lorem ipsum, dolor sit amet consectetur adipisicing elit. Nulla porro atque minima. Nesciunt repellendus culpa deserunt, eveniet ab fugit dolor quae iure expedita, necessitatibus officiis iusto a neque! Corrupti, sint!");
    }


}
