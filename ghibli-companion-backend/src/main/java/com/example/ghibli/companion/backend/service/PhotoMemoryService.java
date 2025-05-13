package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.PhotoMemory;
import com.example.ghibli.companion.backend.repository.PhotoMemoryRepository;
@Service
public class PhotoMemoryService {
    @Autowired
    private PhotoMemoryRepository repository;
    public List<PhotoMemory> getAllPhotoMemories() {
        return repository.findAll();
    }
    public Optional<PhotoMemory> getPhotoMemoryById(Long id) {
        return repository.findById(id);
    }
    public PhotoMemory createPhotoMemory(PhotoMemory photoMemory) {
        return repository.save(photoMemory);
    }
    public PhotoMemory updatePhotoMemory(Long id, PhotoMemory photoMemory) {
        if (repository.existsById(id)) {
            photoMemory.setId(id);
            return repository.save(photoMemory);
        }
        return null;
    }
    public boolean deletePhotoMemory(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}