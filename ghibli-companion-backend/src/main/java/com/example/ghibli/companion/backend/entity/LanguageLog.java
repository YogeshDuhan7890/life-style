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
@Table(name = "language_logs")
public class LanguageLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String inputText;
    private String translatedText;
    @Column(nullable = false)
    private String sourceLanguage;
    @Column(nullable = false)
    private String targetLanguage;
    private String timestamp;
    @Column(nullable = false)
    private Long userId;
}