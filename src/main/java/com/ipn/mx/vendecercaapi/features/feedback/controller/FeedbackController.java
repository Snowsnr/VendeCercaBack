package com.ipn.mx.vendecercaapi.features.feedback.controller;

import com.ipn.mx.vendecercaapi.entidades.Feedback;
import com.ipn.mx.vendecercaapi.features.feedback.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/feedbacks")
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Feedback> findAll() {
        return feedbackService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Feedback findById(@PathVariable Long id) {
        return feedbackService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Feedback create(@RequestBody Feedback feedback) {
        return feedbackService.save(feedback);
    }

    @PutMapping("/{id}")
    public Feedback update(@PathVariable Long id, @RequestBody Feedback feedback) {
        Feedback f = feedbackService.findById(id);
        f.setFedTexto(feedback.getFedTexto());
        f.setFedEstrella(feedback.getFedEstrella());
        f.setFedFecha(feedback.getFedFecha());
        f.setPerId(feedback.getPerId());
        f.setNegId(feedback.getNegId());
        return feedbackService.save(f);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        feedbackService.deleteById(id);
    }
}
