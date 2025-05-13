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

import com.example.ghibli.companion.backend.entity.Goal;
import com.example.ghibli.companion.backend.service.GoalService;
@RestController
@RequestMapping("/api/goals")
public class GoalController {
    @Autowired
    private GoalService service;
    @GetMapping
    public List<Goal> getAllGoals() {
        return service.getAllGoals();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Goal> getGoalById(@PathVariable Long id) {
        Optional<Goal> goal = service.getGoalById(id);
        return goal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public Goal createGoal(@RequestBody Goal goal) {
        return service.createGoal(goal);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Goal> updateGoal(@PathVariable Long id, @RequestBody Goal goal) {
        Goal updated = service.updateGoal(id, goal);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Long id) {
        return service.deleteGoal(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}