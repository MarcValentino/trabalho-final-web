package com.marcelovalentino.falamundobackend.repository;

import com.marcelovalentino.falamundobackend.model.Curso;
import jakarta.persistence.LockModeType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CursoRepository extends JpaRepository<Curso, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    @Query("select p from Curso p left outer join fetch p.lingua where p.id = :id")
    Optional<Curso> recuperarCursoPorIdComLock(@Param("id") Long id);
//
    @Query("select p from Curso p left outer join fetch p.lingua order by p.id")
    List<Curso> recuperarCursosComLingua();
//
    @Query("select p from Curso p left outer join fetch p.lingua where p.id = :id")
    Optional<Curso> recuperarCursoPorId(@Param("id") Long id);

    @Query(
            value = "select p " +
                    "from Curso p " +
                    "left outer join fetch p.lingua " +
                    "where p.nome like :nome " +
                    "order by p.id",
            countQuery = "select count(p) from Curso p where p.nome like :nome"
    )
    Page<Curso> recuperarCursosComPaginacao(Pageable pageable, @Param("nome") String nome);

    @Query("select p from Curso p " +
            "left outer join fetch p.lingua c " +
            "where c.slug = :slugLingua " +
            "order by p.id")
    List<Curso> recuperarCursosPorSlugLingua(@Param("slugLingua") String slugLingua);

    @Query(
            value = "select p from Curso p " +
                    "left outer join fetch p.lingua c " +
                    "where c.slug = :slug " +
                    "order by p.id",
            countQuery = "select count(p) " +
                    "from Curso p " +
                    "left outer join p.lingua c " +
                    "where c.slug = :slug "
    )
    Page<Curso> recuperarCursosPaginadosPorSlugDaLingua(@Param("slug") String slug, Pageable pageable);

    @Query(
            value = "select p from Curso p " +
                    "left outer join fetch p.lingua c " +
                    "order by p.id",
            countQuery = "select count(p) from Curso p "
    )
    Page<Curso> recuperarCursosPaginados(Pageable pageable);
}
