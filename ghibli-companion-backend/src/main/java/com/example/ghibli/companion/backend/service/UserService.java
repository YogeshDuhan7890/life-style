package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.User;
import com.example.ghibli.companion.backend.repository.UserRepository;
@Service
public class UserService {
    @Autowired
    private UserRepository repository;
    public List<User> getAllUsers() {
        return repository.findAll();
    }
    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }
    public User createUser(User user) {
        return repository.save(user);
    }
    public User updateUser(Long id, User user) {
        if (repository.existsById(id)) {
            user.setId(id);
            return repository.save(user);
        }
        return null;
    }
    public boolean deleteUser(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}