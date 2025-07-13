package com.marcelovalentino.falamundobackend.controller;

import com.marcelovalentino.falamundobackend.model.Carrinho;
import com.marcelovalentino.falamundobackend.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.marcelovalentino.falamundobackend.dto.AdicionarCursoDTO;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("carrinho")   // http://localhost:8080/autenticacao
public class CarrinhoController {

    @Autowired
    private CarrinhoService carrinhoService;

    @GetMapping("usuario/{idUsuario}")
    public List<Carrinho> verCarrinho(@PathVariable("idUsuario") String id) {
        return carrinhoService.mostrarCarrinhoUsuario(id);

    }

    @PostMapping("usuario/{idUsuario}/adicionar")
    public Carrinho adicionarAoCarrinho(@PathVariable Long idUsuario, @RequestBody AdicionarCursoDTO request) {
        return carrinhoService.adicionarCursoAoCarrinho(idUsuario, request.getIdCurso());
    }

    @DeleteMapping("{idCarrinho}")
    public void removerItem(@PathVariable("idCarrinho") long id) {
        carrinhoService.removerItem(id);
    }

    @PostMapping("usuario/{idUsuario}/fechar")
    public void comprarCarrinho(@PathVariable("idUsuario") String idUsuario) {
        carrinhoService.fecharCarrinho(idUsuario);
    }
}
