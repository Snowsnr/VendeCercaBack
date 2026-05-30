package com.ipn.mx.vendecercaapi.features.chat.controller;

import com.ipn.mx.vendecercaapi.entidades.Chat;
import com.ipn.mx.vendecercaapi.features.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/chats")
public class ChatController {
    @Autowired
    private ChatService chatService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Chat> findAll() {
        return chatService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Chat findById(@PathVariable Long id) {
        return chatService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chat create(@RequestBody Chat chat) {
        return chatService.save(chat);
    }

    @PutMapping("/{id}")
    public Chat update(@PathVariable Long id, @RequestBody Chat chat) {
        Chat c = chatService.findById(id);
        c.setPerIdComprador(chat.getPerIdComprador());
        c.setPerIdVendedor(chat.getPerIdVendedor());
        c.setNegId(chat.getNegId());
        c.setMensajes(chat.getMensajes());
        return chatService.save(c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        chatService.deleteById(id);
    }
}
