package com.marcelovalentino.falamundobackend.repository;

import com.marcelovalentino.falamundobackend.model.Carrinho;
import com.marcelovalentino.falamundobackend.model.Curso;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<Carrinho, Long> {
    @Query(
            value = "select cr from Carrinho cr " +
                    "join fetch cr.usuario u " +
                    "where u.id = :id " +
                    "and not cr.vendido"
            ,
            countQuery = "select count(cr) " +
            "from Carrinho cr " +
            "join fetch cr.usuario u " +
            "where u.id = :id " +
            "and not cr.vendido"
    )
    List<Carrinho> recuperarCursosPorIdUsuario(@Param("id") String id);

}
