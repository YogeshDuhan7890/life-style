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

import com.example.ghibli.companion.backend.entity.Relationship;
import com.example.ghibli.companion.backend.service.RelationshipService;
@RestController
@RequestMapping("/api/relationships")
public class RelationshipController {
    @Autowired
    private RelationshipService service;
    @GetMapping
    public List<Relationship> getAllRelationships() {
        return service.getAllRelationships();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Relationship> getRelationshipById(@PathVariable Long id) {
        Optional<Relationship> relationship = service.getRelationshipById(id);
        return relationship.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Relationship createRelationship(@RequestBody Relationship relationship) {
        return service.createRelationship(relationship);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Relationship> updateRelationship(@PathVariable Long id, @RequestBody Relationship relationship) {
        Relationship updated = service.updateRelationship(id, relationship);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRelationship(@PathVariable Long id) {
        return service.deleteRelationship(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}