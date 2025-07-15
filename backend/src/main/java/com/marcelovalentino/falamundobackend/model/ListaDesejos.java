package com.marcelovalentino.falamundobackend.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ListaDesejos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private Usuario usuario;

    @ManyToOne(optional = false)
    private Curso curso;

    public ListaDesejos(Curso curso, Usuario usuario) {
        this.curso = curso;
        this.usuario = usuario;
    }
}

