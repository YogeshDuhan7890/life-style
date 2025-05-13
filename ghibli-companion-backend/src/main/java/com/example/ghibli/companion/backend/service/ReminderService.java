package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.Reminder;
import com.example.ghibli.companion.backend.repository.ReminderRepository;
@Service
public class ReminderService {
    @Autowired
    private ReminderRepository repository;
    public List<Reminder> getAllReminders() {
        return repository.findAll();
    }
    public Optional<Reminder> getReminderById(Long id) {
        return repository.findById(id);
    }
    public Reminder createReminder(Reminder reminder) {
        return repository.save(reminder);
    }
    public Reminder updateReminder(Long id, Reminder reminder) {
        if (repository.existsById(id)) {
            reminder.setId(id);
            return repository.save(reminder);
        }
        return null;
    }
    public boolean deleteReminder(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}