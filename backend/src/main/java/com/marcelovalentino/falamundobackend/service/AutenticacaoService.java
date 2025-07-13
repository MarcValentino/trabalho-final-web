package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.exception.ContaJaCadastradaException;
import com.marcelovalentino.falamundobackend.exception.CredenciaisInvalidasException;
import com.marcelovalentino.falamundobackend.exception.EmailJaCadastradoException;
import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutenticacaoService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario login(Usuario usuario) {
        Usuario user = usuarioRepository.findByEmailAndSenha(
                usuario.getEmail(), usuario.getSenha());
        if (user != null) {
            return user;
        }
        else throw new CredenciaisInvalidasException();

    }

    public Usuario cadastrarUsuario(String conta, String senha, String email) {
        if (usuarioRepository.existsByConta(conta)) {
            throw new ContaJaCadastradaException();
        }
        if (usuarioRepository.existsByEmail(email)) {
            throw new EmailJaCadastradoException();
        }
        Usuario usuario = new Usuario(conta, senha, email);
        return usuarioRepository.save(usuario);
    }
}
