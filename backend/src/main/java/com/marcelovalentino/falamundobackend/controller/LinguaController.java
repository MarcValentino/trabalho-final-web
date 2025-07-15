package com.marcelovalentino.falamundobackend.controller;

import com.marcelovalentino.falamundobackend.service.LinguaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/linguas")
public class LinguaController {
    @Autowired
    private LinguaService linguaService;

    @GetMapping
    public List<Map<String, String>> listarLinguas() {
        return linguaService.listarLinguas();
    }
}

