package com.marcelovalentino.falamundobackend.repository;

import com.marcelovalentino.falamundobackend.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByContaAndSenha(String conta, String senha);
    Usuario findByEmailAndSenha(String email, String senha);
}
