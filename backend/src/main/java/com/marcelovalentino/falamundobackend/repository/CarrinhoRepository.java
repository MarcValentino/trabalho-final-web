package com.marcelovalentino.falamundobackend.repository;

import com.marcelovalentino.falamundobackend.model.Carrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Modifying
    @Transactional
    @Query("update Carrinho cr set cr.vendido = true where cr.usuario.id = :id and cr.vendido = false")
    int fecharCarrinhoPorUsuario(@Param("id") String id);

    @Query(
            value=  "select cr from Carrinho cr " +
                    "join fetch cr.usuario u " +
                    "join fetch cr.curso c " +
                    "where u.id = :idUsuario " +
                    "and c.id = :idCurso " +
                    "and not cr.vendido"
    )
    Optional<Carrinho> recuperarCarrinhoPorUsuarioECurso(@Param("idUsuario") Long idUsuario, @Param("idCurso") Long idCurso);
}
