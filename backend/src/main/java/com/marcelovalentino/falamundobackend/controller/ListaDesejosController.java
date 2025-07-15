package com.marcelovalentino.falamundobackend.controller;

import com.marcelovalentino.falamundobackend.model.ListaDesejos;
import com.marcelovalentino.falamundobackend.service.ListaDesejosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("lista-desejos")
public class ListaDesejosController {
    @Autowired
    private ListaDesejosService listaDesejosService;

    @GetMapping("usuario/{idUsuario}")
    public List<ListaDesejos> listarPorUsuario(@PathVariable Long idUsuario) {
        return listaDesejosService.listarPorUsuario(idUsuario);
    }

    @PostMapping("usuario/{idUsuario}/adicionar/{idCurso}")
    public ListaDesejos adicionarCurso(@PathVariable Long idUsuario, @PathVariable Long idCurso) {
        return listaDesejosService.adicionarCurso(idUsuario, idCurso);
    }

    @DeleteMapping("usuario/{idUsuario}/remover/{idCurso}")
    public void removerCurso(@PathVariable Long idUsuario, @PathVariable Long idCurso) {
        listaDesejosService.removerCurso(idUsuario, idCurso);
    }
}

