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

import com.example.ghibli.companion.backend.entity.Birthday;
import com.example.ghibli.companion.backend.service.BirthdayService;
@RestController
@RequestMapping("/api/birthdays")
public class BirthdayController {
    @Autowired
    private BirthdayService service;
    @GetMapping
    public List<Birthday> getAllBirthdays() {
        return service.getAllBirthdays();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Birthday> getBirthdayById(@PathVariable Long id) {
        Optional<Birthday> birthday = service.getBirthdayById(id);
        return birthday.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Birthday createBirthday(@RequestBody Birthday birthday) {
        return service.createBirthday(birthday);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Birthday> updateBirthday(@PathVariable Long id, @RequestBody Birthday birthday) {
        Birthday updated = service.updateBirthday(id, birthday);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBirthday(@PathVariable Long id) {
        return service.deleteBirthday(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}