package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.PhotoMemory;
public interface PhotoMemoryRepository extends JpaRepository<PhotoMemory, Long> {}