package com.example.ghibli.companion.backend.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ghibli.companion.backend.entity.VoiceJournal;
public interface VoiceJournalRepository extends JpaRepository<VoiceJournal, Long> {}