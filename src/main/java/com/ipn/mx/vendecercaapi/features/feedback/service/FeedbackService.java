package com.ipn.mx.vendecercaapi.features.feedback.service;

import com.ipn.mx.vendecercaapi.entidades.Feedback;

import java.util.List;

public interface FeedbackService {
    public List<Feedback> findAll();
    public Feedback findById(Long id);
    public Feedback save(Feedback feedback);
    public void deleteById(Long id);
}
