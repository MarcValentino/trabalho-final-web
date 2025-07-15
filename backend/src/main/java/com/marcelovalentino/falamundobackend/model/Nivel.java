package com.marcelovalentino.falamundobackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Nivel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "O nome do nível deve ser informado.")
    @Column(unique = true)
    private String nome;

    @NotEmpty(message = "O slug do nível deve ser informado.")
    @Column(unique = true)
    private String slug;

    public Nivel(String nome, String slug) {
        this.nome = nome;
        this.slug = slug;
    }
}

