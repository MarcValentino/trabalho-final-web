package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.exception.EntidadeNaoEncontradaException;
import com.marcelovalentino.falamundobackend.model.Carrinho;
import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.repository.CarrinhoRepository;
import com.marcelovalentino.falamundobackend.repository.CursoRepository;
import com.marcelovalentino.falamundobackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository carrinhoRepository;
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public List<Carrinho> mostrarCarrinhoUsuario(String id) {
        return carrinhoRepository.recuperarCursosPorIdUsuario(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public void removerItem(long id) {
        carrinhoRepository.deleteById(id);
    }

    @Transactional
    public Carrinho adicionarCursoAoCarrinho(Long idUsuario, Long idCurso) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        if (usuarioOpt.isEmpty() || cursoOpt.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Usuário ou curso não encontrado");
        }
        Optional<Carrinho> carrinho_presente = carrinhoRepository.recuperarCarrinhoPorUsuarioECurso(usuarioOpt.get().getId(), cursoOpt.get().getId());
        if(carrinho_presente.isEmpty()){
            Carrinho carrinho = new Carrinho(cursoOpt.get(), usuarioOpt.get());
            return carrinhoRepository.save(carrinho);
        }
        return carrinho_presente.get();
    }

    @Transactional
    public void fecharCarrinho(String idUsuario) {
        carrinhoRepository.fecharCarrinhoPorUsuario(idUsuario);
    }
}
