package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.LanguageLog;
public interface LanguageLogRepository extends JpaRepository<LanguageLog, Long> {}