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

import com.example.ghibli.companion.backend.entity.LanguageProgress;
import com.example.ghibli.companion.backend.service.LanguageProgressService;
@RestController
@RequestMapping("/api/language_progress")
public class LanguageProgressController {
    @Autowired
    private LanguageProgressService service;
    @GetMapping
    public List<LanguageProgress> getAllLanguageProgress() {
        return service.getAllLanguageProgress();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LanguageProgress> getLanguageProgressById(@PathVariable Long id) {
        Optional<LanguageProgress> languageProgress = service.getLanguageProgressById(id);
        return languageProgress.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public LanguageProgress createLanguageProgress(@RequestBody LanguageProgress languageProgress) {
        return service.createLanguageProgress(languageProgress);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LanguageProgress> updateLanguageProgress(@PathVariable Long id, @RequestBody LanguageProgress languageProgress) {
        LanguageProgress updated = service.updateLanguageProgress(id, languageProgress);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguageProgress(@PathVariable Long id) {
        return service.deleteLanguageProgress(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}