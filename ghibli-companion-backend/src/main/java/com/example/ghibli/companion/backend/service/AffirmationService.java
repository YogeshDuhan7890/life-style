package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.Affirmation;
import com.example.ghibli.companion.backend.repository.AffirmationRepository;
@Service
public class AffirmationService {
    @Autowired
    private AffirmationRepository repository;
    public List<Affirmation> getAllAffirmations() {
        return repository.findAll();
    }
    public Optional<Affirmation> getAffirmationById(Long id) {
        return repository.findById(id);
    }
    public Affirmation createAffirmation(Affirmation affirmation) {
        return repository.save(affirmation);
    }
    public Affirmation updateAffirmation(Long id, Affirmation affirmation) {
        if (repository.existsById(id)) {
            affirmation.setId(id);
            return repository.save(affirmation);
        }
        return null;
    }
    public boolean deleteAffirmation(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}