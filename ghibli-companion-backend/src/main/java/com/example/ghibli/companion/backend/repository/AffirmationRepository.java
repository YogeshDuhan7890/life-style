package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.Affirmation;
public interface AffirmationRepository extends JpaRepository<Affirmation, Long> {}