package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.Birthday;
public interface BirthdayRepository extends JpaRepository<Birthday, Long> {}