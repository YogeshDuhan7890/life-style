package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.WorkoutLog;
public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {}