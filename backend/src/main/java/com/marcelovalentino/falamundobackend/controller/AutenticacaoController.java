package com.marcelovalentino.falamundobackend.controller;

import com.marcelovalentino.falamundobackend.dto.UsuarioCadastroDTO;
import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.service.AutenticacaoService;
import com.marcelovalentino.falamundobackend.util.TokenResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("auth")   // http://localhost:8080/autenticacao
public class AutenticacaoController {

    @Autowired
    private AutenticacaoService autenticacaoService;

    @PostMapping("login")  // http://localhost:8080/autenticacao/login
    public TokenResponse login(@RequestBody Usuario usuario) {
        System.out.println(usuario.getEmail() + " " + usuario.getSenha());
        Usuario usuarioLogado = autenticacaoService.login(usuario);
        return new TokenResponse(usuarioLogado.getId());
    }

    @PostMapping("cadastro")
    public TokenResponse cadastrar(@Valid @RequestBody UsuarioCadastroDTO dto) {
        Usuario usuario = autenticacaoService.cadastrarUsuario(dto.getConta(), dto.getSenha(), dto.getEmail());
        if (usuario != null) {
            return new TokenResponse(usuario.getId());
        } else {
            return new TokenResponse(0);
        }
    }
}
