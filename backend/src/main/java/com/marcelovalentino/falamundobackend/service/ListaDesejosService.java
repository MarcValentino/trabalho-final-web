package com.marcelovalentino.falamundobackend.service;

import com.marcelovalentino.falamundobackend.exception.EntidadeNaoEncontradaException;
import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.ListaDesejos;
import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.repository.CursoRepository;
import com.marcelovalentino.falamundobackend.repository.ListaDesejosRepository;
import com.marcelovalentino.falamundobackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ListaDesejosService {
    @Autowired
    private ListaDesejosRepository listaDesejosRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private CursoRepository cursoRepository;

    @Transactional
    public ListaDesejos adicionarCurso(Long idUsuario, Long idCurso) {
        if (listaDesejosRepository.existsByUsuarioIdAndCursoId(idUsuario, idCurso)) {
            throw new RuntimeException("Curso já está na lista de desejos.");
        }
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(idUsuario);
        Optional<Curso> cursoOpt = cursoRepository.findById(idCurso);
        if (usuarioOpt.isEmpty() || cursoOpt.isEmpty()) {
            throw new EntidadeNaoEncontradaException("Usuário ou curso não encontrado");
        }
        ListaDesejos listaDesejos = new ListaDesejos(cursoOpt.get(), usuarioOpt.get());
        return listaDesejosRepository.save(listaDesejos);
    }

    @Transactional
    public void removerCurso(Long idUsuario, Long idCurso) {
        listaDesejosRepository.deleteByUsuarioIdAndCursoId(idUsuario, idCurso);
    }

    public List<ListaDesejos> listarPorUsuario(Long idUsuario) {
        return listaDesejosRepository.findByUsuarioId(idUsuario);
    }
}

