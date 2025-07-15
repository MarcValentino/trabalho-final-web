package com.marcelovalentino.falamundobackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @NotEmpty(message = "A 'Conta' deve ser informada.")
    @Column(unique = true, nullable = false)
    private String conta;
    // @NotEmpty(message = "A 'Senha' deve ser informada.")
    private String senha;
    @Column(unique = true, nullable = false)
    @NotEmpty(message = "O email deve ser informado.")
    private String email;

    private boolean admin;

    public Usuario(String conta, String senha, String email) {
        this.conta = conta;
        this.senha = senha;
        this.email = email;
        this.admin = false; // Por padrão, o usuário não é admin
    }

    public Usuario(String conta, String senha, String email, boolean admin) {
        this.conta = conta;
        this.senha = senha;
        this.email = email;
        this.admin = admin;
    }
}
