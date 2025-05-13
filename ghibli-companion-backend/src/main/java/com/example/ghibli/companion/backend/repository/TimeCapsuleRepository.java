package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.TimeCapsule;
public interface TimeCapsuleRepository extends JpaRepository<TimeCapsule, Long> {}