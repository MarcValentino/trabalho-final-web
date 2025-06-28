package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.exception.EntidadeNaoEncontradaException;
import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> recuperarCursos() {
        return cursoRepository.recuperarCursosComLingua();
    }

    public Curso cadastrarCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

//    public Curso alterarCurso(Curso produto) {
//        Optional<Curso> opt = produtoRepository.findById(produto.getId());
//        if (opt.isPresent()) {
//            return produtoRepository.save(produto);
//        }
//        throw new CursoNaoEncontradoException(
//                "Curso número " + produto.getId() + " não encontrado.");
//    }

//    @Transactional
//    public Curso alterarCurso(Curso produto) {
//        Optional<Curso> opt = produtoRepository.recuperarCursoPorIdComLock(produto.getId());
//        if (opt.isPresent()) {
//            return produtoRepository.save(produto);
//        }
//        throw new CursoNaoEncontradoException(
//                "Curso número " + produto.getId() + " não encontrado.");
//    }

    @Transactional
    public Curso alterarCurso(Curso curso) {
        cursoRepository.recuperarCursoPorIdComLock(curso.getId())
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                    "Curso número " + curso.getId() + " não encontrado."));
        return cursoRepository.save(curso);
    }

    @Transactional(rollbackFor = Exception.class)
    public void removerCurso(long id) {
        cursoRepository.deleteById(id);
//        produtoRepository.deleteById(1L);
//        if (true) {
//            throw new Exception("Deu erro!");
//        }
//        produtoRepository.deleteById(2L);
    }

    public Curso recuperarCursoPorId(long id) {
        return cursoRepository.recuperarCursoPorId(id)
            .orElseThrow(() -> new EntidadeNaoEncontradaException(
                "Curso número " + id + " não encontrado."));
    }

    public Page<Curso> recuperarCursosComPaginacao(Pageable pageable, String nome) {
        return cursoRepository.recuperarCursosComPaginacao(pageable, "%" + nome + "%");
    }

    public List<Curso> recuperarCursosPorSlugLingua(String slugLingua) {
        return cursoRepository.recuperarCursosPorSlugLingua(slugLingua);
    }

    public Page<Curso> recuperarCursosPaginadosPorSlugDaLingua(String slugLingua, Pageable pageable) {
        if(!slugLingua.isEmpty()) {
            return cursoRepository.recuperarCursosPaginadosPorSlugDaLingua(slugLingua, pageable);
        }
        else {
            return cursoRepository.recuperarCursosPaginados(pageable);
        }
    }
}
