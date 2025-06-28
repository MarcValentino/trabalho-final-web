package com.marcelovalentino.falamundobackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Carrinho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O 'Curso' deve ser informado.")
    @ManyToOne
    private Curso curso;

    @NotNull(message = "O 'Usuário' deve ser informado.")
    @ManyToOne
    private Usuario usuario;

//    private Boolean ativo;

//    @NotNull(message = "A 'Data de Cadastro' deve ser informada.")
//    private LocalDate dataCriacao;

    private Boolean vendido;

    public Carrinho(Curso curso, Usuario usuario) {
        this.curso = curso;
        this.usuario = usuario;
        this.vendido = false;
    }

    public Carrinho(Curso curso, Usuario usuario, boolean vendido) {
        this.curso = curso;
        this.usuario = usuario;
        this.vendido = vendido;
    }
}
