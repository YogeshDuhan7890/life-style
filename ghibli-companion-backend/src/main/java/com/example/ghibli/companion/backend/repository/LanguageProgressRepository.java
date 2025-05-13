package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.LanguageProgress;
public interface LanguageProgressRepository extends JpaRepository<LanguageProgress, Long> {}