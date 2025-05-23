package com.example.ghibli.companion.backend.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
@Entity
@Data
@Table(name = "language_progress")
public class LanguageProgress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String language;
    @Column(nullable = false)
    private Integer lessonCompleted;
    private Integer score;
    private String timestamp;
    @Column(nullable = false)
    private Long userId;
}