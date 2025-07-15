package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.model.Nivel;
import com.marcelovalentino.falamundobackend.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Map;

@Service
public class NivelService {
    @Autowired
    private NivelRepository nivelRepository;

    public List<Map<String, String>> listarNiveis() {
        return nivelRepository.findAll().stream()
                .map(n -> Map.of("nome", n.getNome(), "slug", gerarSlug(n.getNome())))
                .collect(Collectors.toList());
    }

    private String gerarSlug(String nome) {
        return nome.toLowerCase().replace(" ", "-");
    }
}

