package com.ipn.mx.vendecercaapi.features.mail.service.impl;

import com.ipn.mx.vendecercaapi.features.mail.service.mailService;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


@Service
public class mailServiceImpl implements mailService{
    @Autowired
    private JavaMailSender mailSender;

    @Value("classpath:static/img/Ipn.png")
    Resource resourceFile;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public void enviarCorreoEelectronico(String to, String subject, String text) {
        MimeMessage mensaje = mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try{
            helper = new MimeMessageHelper(mensaje,
                    true,
                    "UTF-8");

            helper.addAttachment("Ipn.png", resourceFile);

            helper.setFrom(from,
                    "Envio de correos via Spring");

            helper.setSubject(subject);
            helper.setText(text, true);
            helper.setTo(to);
            helper.setCc("reyes.salazar.diego1@gmail.com");
            helper.setBcc("reyes.salazar.diego1@gmail.com");
            mailSender.send(mensaje);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
