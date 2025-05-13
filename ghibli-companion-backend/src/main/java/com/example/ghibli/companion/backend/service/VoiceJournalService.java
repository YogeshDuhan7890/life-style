package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.VoiceJournal;
import com.example.ghibli.companion.backend.repository.VoiceJournalRepository;
@Service
public class VoiceJournalService {
    @Autowired
    private VoiceJournalRepository repository;
    public List<VoiceJournal> getAllVoiceJournals() {
        return repository.findAll();
    }
    public Optional<VoiceJournal> getVoiceJournalById(Long id) {
        return repository.findById(id);
    }
    public VoiceJournal createVoiceJournal(VoiceJournal voiceJournal) {
        return repository.save(voiceJournal);
    }
    public VoiceJournal updateVoiceJournal(Long id, VoiceJournal voiceJournal) {
        if (repository.existsById(id)) {
            voiceJournal.setId(id);
            return repository.save(voiceJournal);
        }
        return null;
    }
    public boolean deleteVoiceJournal(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}