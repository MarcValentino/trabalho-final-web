package com.marcelovalentino.falamundobackend.controller;

import com.marcelovalentino.falamundobackend.model.Nivel;
import com.marcelovalentino.falamundobackend.service.NivelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("/niveis")
public class NivelController {
    @Autowired
    private NivelService nivelService;

    @GetMapping
    public List<Nivel> listarTodos() {
        return nivelService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nivel> buscarPorId(@PathVariable Long id) {
        Optional<Nivel> nivel = nivelService.buscarPorId(id);
        return nivel.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Nivel salvar(@RequestBody Nivel nivel) {
        return nivelService.salvar(nivel);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        nivelService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

