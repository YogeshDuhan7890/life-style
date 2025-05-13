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

import com.example.ghibli.companion.backend.entity.Reminder;
import com.example.ghibli.companion.backend.service.ReminderService;
@RestController
@RequestMapping("/api/reminders")
public class ReminderController {
    @Autowired
    private ReminderService service;
    @GetMapping
    public List<Reminder> getAllReminders() {
        return service.getAllReminders();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Reminder> getReminderById(@PathVariable Long id) {
        Optional<Reminder> reminder = service.getReminderById(id);
        return reminder.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return service.createReminder(reminder);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Reminder> updateReminder(@PathVariable Long id, @RequestBody Reminder reminder) {
        Reminder updated = service.updateReminder(id, reminder);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReminder(@PathVariable Long id) {
        return service.deleteReminder(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}