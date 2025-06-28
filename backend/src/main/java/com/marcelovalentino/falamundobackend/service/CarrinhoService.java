package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.exception.EntidadeNaoEncontradaException;
import com.marcelovalentino.falamundobackend.model.Carrinho;
import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.repository.CarrinhoRepository;
import com.marcelovalentino.falamundobackend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;

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
    public List<Carrinho> mostrarCarrinhoUsuario(String id) {
        return carrinhoRepository.recuperarCursosPorIdUsuario(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void removerCurso(long id) {
        carrinhoRepository.deleteById(id);
//        produtoRepository.deleteById(1L);
//        if (true) {
//            throw new Exception("Deu erro!");
//        }
//        produtoRepository.deleteById(2L);
    }

//    public Curso recuperarCursoPorId(long id) {
//        return carrinhoRepository.recuperarCursoPorId(id)
//            .orElseThrow(() -> new EntidadeNaoEncontradaException(
//                "Curso número " + id + " não encontrado."));
//    }
//
//    public Page<Curso> recuperarCursosComPaginacao(Pageable pageable, String nome) {
//        return carrinhoRepository.recuperarCursosComPaginacao(pageable, "%" + nome + "%");
//    }
//
//    public List<Curso> recuperarCursosPorSlugLingua(String slugLingua) {
//        return carrinhoRepository.recuperarCursosPorSlugLingua(slugLingua);
//    }
//
//    public Page<Curso> recuperarCursosPaginadosPorSlugDaLingua(String slugLingua, Pageable pageable) {
//        if(!slugLingua.isEmpty()) {
//            return carrinhoRepository.recuperarCursosPaginadosPorSlugDaLingua(slugLingua, pageable);
//        }
//        else {
//            return carrinhoRepository.recuperarCursosPaginados(pageable);
//        }
//    }
}
