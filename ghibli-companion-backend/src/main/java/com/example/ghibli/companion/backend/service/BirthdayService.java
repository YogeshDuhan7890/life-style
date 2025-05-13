package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.Birthday;
import com.example.ghibli.companion.backend.repository.BirthdayRepository;
@Service
public class BirthdayService {
    @Autowired
    private BirthdayRepository repository;
    public List<Birthday> getAllBirthdays() {
        return repository.findAll();
    }
    public Optional<Birthday> getBirthdayById(Long id) {
        return repository.findById(id);
    }
    public Birthday createBirthday(Birthday birthday) {
        return repository.save(birthday);
    }
    public Birthday updateBirthday(Long id, Birthday birthday) {
        if (repository.existsById(id)) {
            birthday.setId(id);
            return repository.save(birthday);
        }
        return null;
    }
    public boolean deleteBirthday(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}