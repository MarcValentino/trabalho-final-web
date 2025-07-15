package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.model.Lingua;
import com.marcelovalentino.falamundobackend.repository.LinguaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service
public class LinguaService {
    @Autowired
    private LinguaRepository linguaRepository;

    public List<Map<String, String>> listarLinguas() {
        return linguaRepository.findAll().stream()
                .map(l -> Map.of("nome", l.getNome(), "slug", l.getSlug()))
                .collect(Collectors.toList());
    }
}

