package com.ipn.mx.vendecercaapi.features.feedback.service.impl;

import com.ipn.mx.vendecercaapi.entidades.Feedback;
import com.ipn.mx.vendecercaapi.features.feedback.repository.FeedbackRepository;
import com.ipn.mx.vendecercaapi.features.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Feedback findById(Long id) {
        return feedbackRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Feedback save(Feedback feedback) {
        return feedbackRepository.save(feedback);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        feedbackRepository.deleteById(id);
    }
}
