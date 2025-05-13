package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.Goal;
import com.example.ghibli.companion.backend.repository.GoalRepository;
@Service
public class GoalService {
    @Autowired
    private GoalRepository repository;
    public List<Goal> getAllGoals() {
        return repository.findAll();
    }
    public Optional<Goal> getGoalById(Long id) {
        return repository.findById(id);
    }
    public Goal createGoal(Goal goal) {
        return repository.save(goal);
    }
    public Goal updateGoal(Long id, Goal goal) {
        if (repository.existsById(id)) {
            goal.setId(id);
            return repository.save(goal);
        }
        return null;
    }
    public boolean deleteGoal(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}