package com.ipn.mx.vendecercaapi.features.chat.service.impl;

import com.ipn.mx.vendecercaapi.entidades.Chat;
import com.ipn.mx.vendecercaapi.features.chat.repository.ChatRepository;
import com.ipn.mx.vendecercaapi.features.chat.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ChatServiceImpl implements ChatService {
    @Autowired
    private ChatRepository chatRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Chat> findAll() {
        return chatRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Chat findById(Long id) {
        return chatRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        chatRepository.deleteById(id);
    }
}
