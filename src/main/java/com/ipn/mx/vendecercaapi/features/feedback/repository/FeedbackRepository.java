package com.ipn.mx.vendecercaapi.features.feedback.repository;

import com.ipn.mx.vendecercaapi.entidades.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}
