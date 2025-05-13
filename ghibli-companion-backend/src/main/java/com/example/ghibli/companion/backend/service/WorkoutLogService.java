package com.example.ghibli.companion.backend.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.WorkoutLog;
import com.example.ghibli.companion.backend.repository.WorkoutLogRepository;
@Service
public class WorkoutLogService {
    @Autowired
    private WorkoutLogRepository repository;
    public List<WorkoutLog> getAllWorkoutLogs() {
        return repository.findAll();
    }
    public Optional<WorkoutLog> getWorkoutLogById(Long id) {
        return repository.findById(id);
    }
    public WorkoutLog createWorkoutLog(WorkoutLog workoutLog) {
        return repository.save(workoutLog);
    }
    public WorkoutLog updateWorkoutLog(Long id, WorkoutLog workoutLog) {
        if (repository.existsById(id)) {
            workoutLog.setId(id);
            return repository.save(workoutLog);
        }
        return null;
    }
    public boolean deleteWorkoutLog(Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}