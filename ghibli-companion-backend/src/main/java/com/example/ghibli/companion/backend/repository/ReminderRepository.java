package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.Reminder;
public interface ReminderRepository extends JpaRepository<Reminder, Long> {}