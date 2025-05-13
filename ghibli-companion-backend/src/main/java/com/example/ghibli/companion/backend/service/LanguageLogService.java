package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.LanguageLog;
import com.example.ghibli.companion.backend.repository.LanguageLogRepository;
@Service
public class LanguageLogService {
    @Autowired
    private LanguageLogRepository repository;
    public List<LanguageLog> getAllLanguageLogs() {
        return repository.findAll();
    }
    public Optional<LanguageLog> getLanguageLogById(Long id) {
        return repository.findById(id);
    }
    public LanguageLog createLanguageLog(LanguageLog languageLog) {
        return repository.save(languageLog);
    }
    public LanguageLog updateLanguageLog(Long id, LanguageLog languageLog) {
        if (repository.existsById(id)) {
            languageLog.setId(id);
            return repository.save(languageLog);
        }
        return null;
    }
    public boolean deleteLanguageLog(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}