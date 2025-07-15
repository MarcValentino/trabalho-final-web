package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.exception.EntidadeNaoEncontradaException;
import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.Lingua;
import com.marcelovalentino.falamundobackend.model.Nivel;
import com.marcelovalentino.falamundobackend.repository.CursoRepository;
import com.marcelovalentino.falamundobackend.repository.LinguaRepository;
import com.marcelovalentino.falamundobackend.repository.NivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private LinguaRepository linguaRepository;

    @Autowired
    private NivelRepository nivelRepository;

    public List<Curso> recuperarCursos() {
        return cursoRepository.recuperarCursosComLingua();
    }

    public Curso cadastrarCurso(Curso curso) {
        Curso cursoCadastrado = curso;
        Optional<Lingua> lingua = linguaRepository.recuperarLinguaPorSlug(curso.getLingua().getSlug());
        if (lingua.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Língua não encontrada.");
        }
        Optional<Nivel> nivel = nivelRepository.recuperarNivelPorSlug(curso.getNivel().getSlug());
        if (nivel.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Nível não encontrado.");
        }
        curso.setLingua(lingua.get());
        curso.setNivel(nivel.get());//        Curso cursoCadastrado = curso.setLingua();
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

    public Page<Curso> recuperarCursosComPaginacao(Pageable pageable, String nome, String lingua, String nivel) {

        return cursoRepository.recuperarCursosComPaginacao(pageable, "%" + nome + "%", "%" + lingua + "%","%" + nivel + "%");
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
