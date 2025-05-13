package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.Relationship;
import com.example.ghibli.companion.backend.repository.RelationshipRepository;
@Service
public class RelationshipService {
    @Autowired
    private RelationshipRepository repository;
    public List<Relationship> getAllRelationships() {
        return repository.findAll();
    }
    public Optional<Relationship> getRelationshipById(Long id) {
        return repository.findById(id);
    }
    public Relationship createRelationship(Relationship relationship) {
        return repository.save(relationship);
    }
    public Relationship updateRelationship(Long id, Relationship relationship) {
        if (repository.existsById(id)) {
            relationship.setId(id);
            return repository.save(relationship);
        }
        return null;
    }
    public boolean deleteRelationship(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}