package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.FamilyMember;
public interface FamilyMemberRepository extends JpaRepository<FamilyMember, Long> {}