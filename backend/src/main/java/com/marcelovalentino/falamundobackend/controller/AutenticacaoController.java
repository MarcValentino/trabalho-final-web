package com.marcelovalentino.falamundobackend.controller;

import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.service.AutenticacaoService;
import com.marcelovalentino.falamundobackend.util.TokenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("carrinho")   // http://localhost:8080/autenticacao
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("login")  // http://localhost:8080/autenticacao/login
    public TokenResponse login(@RequestBody Usuario usuario) {
        System.out.println(usuario.getConta() + " " + usuario.getSenha());
        Usuario usuarioLogado = autenticacaoService.login(usuario);
        if (usuarioLogado != null) {
            return new TokenResponse(usuarioLogado.getId());
        } else {
            return new TokenResponse(0);
        }
    }
}
