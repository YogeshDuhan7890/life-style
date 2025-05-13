package com.example.ghibli.companion.backend.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ghibli.companion.backend.entity.GratitudeLog;
import com.example.ghibli.companion.backend.repository.GratitudeLogRepository;
@Service
public class GratitudeLogService {
    @Autowired
    private GratitudeLogRepository repository;
    public List<GratitudeLog> getAllGratitudeLogs() {
        return repository.findAll();
    }
}