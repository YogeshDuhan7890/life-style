package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.LanguageProgress;
import com.example.ghibli.companion.backend.repository.LanguageProgressRepository;
@Service
public class LanguageProgressService {
    @Autowired
    private LanguageProgressRepository repository;
    public List<LanguageProgress> getAllLanguageProgress() {
        return repository.findAll();
    }
    public Optional<LanguageProgress> getLanguageProgressById(Long id) {
        return repository.findById(id);
    }
    public LanguageProgress createLanguageProgress(LanguageProgress languageProgress) {
        return repository.save(languageProgress);
    }
    public LanguageProgress updateLanguageProgress(Long id, LanguageProgress languageProgress) {
        if (repository.existsById(id)) {
            languageProgress.setId(id);
            return repository.save(languageProgress);
        }
        return null;
    }
    public boolean deleteLanguageProgress(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}