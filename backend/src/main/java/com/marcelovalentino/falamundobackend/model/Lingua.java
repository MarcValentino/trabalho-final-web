package com.marcelovalentino.falamundobackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Lingua {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "O 'Nome' da língua deve ser informado.")
    @Column(unique = true)
    private String nome;

    @NotNull(message = "O 'Slug' da língua deve ser informado.")
    @Column(unique = true)
    private String slug;

    @JsonIgnore
    @OneToMany (mappedBy = "lingua")
    private List<Curso> cursos;

    public Lingua(String nome, String slug) {
        this.nome = nome;
        this.slug = slug;
    }
}
