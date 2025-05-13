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

import com.example.ghibli.companion.backend.entity.VoiceJournal;
import com.example.ghibli.companion.backend.service.VoiceJournalService;
@RestController
@RequestMapping("/api/voice_journals")
public class VoiceJournalController {
    @Autowired
    private VoiceJournalService service;
    @GetMapping
    public List<VoiceJournal> getAllVoiceJournals() {
        return service.getAllVoiceJournals();
    }
    @GetMapping("/{id}")
    public ResponseEntity<VoiceJournal> getVoiceJournalById(@PathVariable Long id) {
        Optional<VoiceJournal> voiceJournal = service.getVoiceJournalById(id);
        return voiceJournal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public VoiceJournal createVoiceJournal(@RequestBody VoiceJournal voiceJournal) {
        return service.createVoiceJournal(voiceJournal);
    }
    @PutMapping("/{id}")
    public ResponseEntity<VoiceJournal> updateVoiceJournal(@PathVariable Long id, @RequestBody VoiceJournal voiceJournal) {
        VoiceJournal updated = service.updateVoiceJournal(id, voiceJournal);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiceJournal(@PathVariable Long id) {
        return service.deleteVoiceJournal(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}