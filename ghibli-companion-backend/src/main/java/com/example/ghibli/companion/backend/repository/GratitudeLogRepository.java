package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.GratitudeLog;
public interface GratitudeLogRepository extends JpaRepository<GratitudeLog, Long> {}