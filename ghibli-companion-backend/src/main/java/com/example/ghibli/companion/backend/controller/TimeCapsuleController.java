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

import com.example.ghibli.companion.backend.entity.TimeCapsule;
import com.example.ghibli.companion.backend.service.TimeCapsuleService;
@RestController
@RequestMapping("/api/time_capsules")
public class TimeCapsuleController {
    @Autowired
    private TimeCapsuleService service;
    @GetMapping
    public List<TimeCapsule> getAllTimeCapsules() {
        return service.getAllTimeCapsules();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TimeCapsule> getTimeCapsuleById(@PathVariable Long id) {
        Optional<TimeCapsule> timeCapsule = service.getTimeCapsuleById(id);
        return timeCapsule.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public TimeCapsule createTimeCapsule(@RequestBody TimeCapsule timeCapsule) {
        return service.createTimeCapsule(timeCapsule);
    }
    @PutMapping("/{id}")
    public ResponseEntity<TimeCapsule> updateTimeCapsule(@PathVariable Long id, @RequestBody TimeCapsule timeCapsule) {
        TimeCapsule updated = service.updateTimeCapsule(id, timeCapsule);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTimeCapsule(@PathVariable Long id) {
        return service.deleteTimeCapsule(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}