package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.Goal;
public interface GoalRepository extends JpaRepository<Goal, Long> {}