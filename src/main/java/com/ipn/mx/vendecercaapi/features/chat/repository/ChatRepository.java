package com.ipn.mx.vendecercaapi.features.chat.repository;

import com.ipn.mx.vendecercaapi.entidades.Chat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatRepository extends JpaRepository<Chat, Long> {
}
