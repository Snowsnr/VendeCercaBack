package com.ipn.mx.vendecercaapi.features.chat.service;

import com.ipn.mx.vendecercaapi.entidades.Chat;

import java.util.List;

public interface ChatService {
    public List<Chat> findAll();
    public Chat findById(Long id);
    public Chat save(Chat chat);
    public void deleteById(Long id);
}
