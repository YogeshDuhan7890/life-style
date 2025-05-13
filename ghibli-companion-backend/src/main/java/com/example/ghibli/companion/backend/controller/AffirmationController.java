package com.example.ghibli.companion.backend.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ghibli.companion.backend.entity.Affirmation;
import com.example.ghibli.companion.backend.service.AffirmationService;
@RestController
@RequestMapping("/api/affirmations")
public class AffirmationController {
    @Autowired
    private AffirmationService service;
    @GetMapping
    public List<Affirmation> getAllAffirmations() {
        return service.getAllAffirmations();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Affirmation> getAffirmationById(@PathVariable Long id) {
        Optional<Affirmation> affirmation = service.getAffirmationById(id);
        return affirmation.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Affirmation createAffirmation(@RequestBody Affirmation affirmation) {
        return service.createAffirmation(affirmation);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Affirmation> updateAffirmation(@PathVariable Long id, @RequestBody Affirmation affirmation) {
        Affirmation updated = service.updateAffirmation(id, affirmation);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAffirmation(@PathVariable Long id) {
        return service.deleteAffirmation(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}