package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.Relationship;
public interface RelationshipRepository extends JpaRepository<Relationship, Long> {}