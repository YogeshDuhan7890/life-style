package com.example.ghibli.companion.backend.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ghibli.companion.backend.entity.GratitudeLog;
import com.example.ghibli.companion.backend.service.GratitudeLogService;
@RestController
@RequestMapping("/api/gratitude_logs")
public class GratitudeLogController {
    @Autowired
    private GratitudeLogService service;
    @GetMapping
    public List<GratitudeLog> getGratitudeLogs() {
        return service.getAllGratitudeLogs();
    }
}