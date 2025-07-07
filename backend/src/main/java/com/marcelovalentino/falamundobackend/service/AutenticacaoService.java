package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(Usuario usuario) {
        // System.out.println("Conta = " + usuario.getConta() + " e senha = " + usuario.getSenha());
        return usuarioRepository.findByEmailAndSenha(
                usuario.getEmail(), usuario.getSenha());
    }

    public Usuario cadastrarUsuario(String conta, String senha, String email) {
        Usuario usuario = new Usuario(conta, senha, email);
        return usuarioRepository.save(usuario);
    }
}
