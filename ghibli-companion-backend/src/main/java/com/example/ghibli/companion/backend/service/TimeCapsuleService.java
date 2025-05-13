package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.TimeCapsule;
import com.example.ghibli.companion.backend.repository.TimeCapsuleRepository;
@Service
public class TimeCapsuleService {
    @Autowired
    private TimeCapsuleRepository repository;
    public List<TimeCapsule> getAllTimeCapsules() {
        return repository.findAll();
    }
    public Optional<TimeCapsule> getTimeCapsuleById(Long id) {
        return repository.findById(id);
    }
    public TimeCapsule createTimeCapsule(TimeCapsule timeCapsule) {
        return repository.save(timeCapsule);
    }
    public TimeCapsule updateTimeCapsule(Long id, TimeCapsule timeCapsule) {
        if (repository.existsById(id)) {
            timeCapsule.setId(id);
            return repository.save(timeCapsule);
        }
        return null;
    }
    public boolean deleteTimeCapsule(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}