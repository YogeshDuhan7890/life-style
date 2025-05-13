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

import com.example.ghibli.companion.backend.entity.WorkoutLog;
import com.example.ghibli.companion.backend.service.WorkoutLogService;
@RestController
@RequestMapping("/api/workout_logs")
public class WorkoutLogController {
    @Autowired
    private WorkoutLogService service;
    @GetMapping
    public List<WorkoutLog> getAllWorkoutLogs() {
        return service.getAllWorkoutLogs();
    }
    @GetMapping("/{id}")
    public ResponseEntity<WorkoutLog> getWorkoutLogById(@PathVariable Long id) {
        Optional<WorkoutLog> workoutLog = service.getWorkoutLogById(id);
        return workoutLog.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public WorkoutLog createWorkoutLog(@RequestBody WorkoutLog workoutLog) {
        return service.createWorkoutLog(workoutLog);
    }
    @PutMapping("/{id}")
    public ResponseEntity<WorkoutLog> updateWorkoutLog(@PathVariable Long id, @RequestBody WorkoutLog workoutLog) {
        WorkoutLog updated = service.updateWorkoutLog(id, workoutLog);
        return updated != null ? ResponseEntity.ok(updated) : ResponseEntity.notFound().build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkoutLog(@PathVariable Long id) {
        return service.deleteWorkoutLog(id) ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}