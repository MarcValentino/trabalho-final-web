package com.marcelovalentino.falamundobackend.repository;

import com.marcelovalentino.falamundobackend.model.ListaDesejos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ListaDesejosRepository extends JpaRepository<ListaDesejos, Long> {
    @Query("select ld from ListaDesejos ld join fetch ld.usuario u where u.id = :id")
    List<ListaDesejos> findByUsuarioId(@Param("id") Long id);
    void deleteByUsuarioIdAndCursoId(Long usuarioId, Long cursoId);
    boolean existsByUsuarioIdAndCursoId(Long usuarioId, Long cursoId);
}

