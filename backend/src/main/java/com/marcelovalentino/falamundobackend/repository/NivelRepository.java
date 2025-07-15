package com.marcelovalentino.falamundobackend.repository;

import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface NivelRepository extends JpaRepository<Nivel, Long> {

    @Query("select p from Nivel p where p.slug = :slug")
    Optional<Nivel> recuperarNivelPorSlug(@Param("slug") String slug);
}

