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

import com.example.ghibli.companion.backend.entity.LanguageLog;
import com.example.ghibli.companion.backend.service.LanguageLogService;
@RestController
@RequestMapping("/api/language_logs")
public class LanguageLogController {
    @Autowired
    private LanguageLogService service;
    @GetMapping
    public List<LanguageLog> getAllLanguageLogs() {
        return service.getAllLanguageLogs();
    }
    @GetMapping("/{id}")
    public ResponseEntity<LanguageLog> getLanguageLogById(@PathVariable Long id) {
        Optional<LanguageLog> languageLog = service.getLanguageLogById(id);
        return languageLog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public LanguageLog createLanguageLog(@RequestBody LanguageLog languageLog) {
        return service.createLanguageLog(languageLog);
    }
    @PutMapping("/{id}")
    public ResponseEntity<LanguageLog> updateLanguageLog(@PathVariable Long id, @RequestBody LanguageLog languageLog) {
        LanguageLog updated = service.updateLanguageLog(id, languageLog);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLanguageLog(@PathVariable Long id) {
        return service.deleteLanguageLog(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}