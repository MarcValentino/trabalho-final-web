package com.marcelovalentino.falamundobackend.repository;

import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.Lingua;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface LinguaRepository extends JpaRepository<Lingua, Long> {

    @Query("select p from Lingua p where p.slug = :slug")
    Optional<Lingua> recuperarLinguaPorSlug(@Param("slug") String slug);
}
