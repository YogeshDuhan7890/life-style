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

import com.example.ghibli.companion.backend.entity.PhotoMemory;
import com.example.ghibli.companion.backend.service.PhotoMemoryService;
@RestController
@RequestMapping("/api/photo_memories")
public class PhotoMemoryController {
    @Autowired
    private PhotoMemoryService service;
    @GetMapping
    public List<PhotoMemory> getAllPhotoMemories() {
        return service.getAllPhotoMemories();
    }
    @GetMapping("/{id}")
    public ResponseEntity<PhotoMemory> getPhotoMemoryById(@PathVariable Long id) {
        Optional<PhotoMemory> photoMemory = service.getPhotoMemoryById(id);
        return photoMemory.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public PhotoMemory createPhotoMemory(@RequestBody PhotoMemory photoMemory) {
        return service.createPhotoMemory(photoMemory);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PhotoMemory> updatePhotoMemory(@PathVariable Long id, @RequestBody PhotoMemory photoMemory) {
        PhotoMemory updated = service.updatePhotoMemory(id, photoMemory);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePhotoMemory(@PathVariable Long id) {
        return service.deletePhotoMemory(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}