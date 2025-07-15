package com.marcelovalentino.falamundobackend.controller;

import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.ResultadoPaginado;
import com.marcelovalentino.falamundobackend.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:5173")
@RestController
@RequestMapping("cursos")  // http://localhost:8080/produtos
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping   // Requisição do tipo GET para http://localhost:8080/produtos
    public List<Curso> recuperarCursos() {
//        if (true) {
//            throw new RuntimeException("Deu erro no servidor");
//        }
        return cursoService.recuperarCursos();
    }

    // Requisição do tipo GET para http://localhost:8080/produtos/1
    @GetMapping("{idCurso}")
    public Curso recuperarCursoPorId(@PathVariable("idCurso") long id) {
        return cursoService.recuperarCursoPorId(id);
    }

    // Requisição do tipo GET para http://localhost:8080/produtos/lingua/frutas
    @GetMapping("lingua/{slugLingua}")
    public List<Curso> recuperarCursosPorSlugLingua(@PathVariable("slugLingua") String slugLingua) {
        return cursoService.recuperarCursosPorSlugLingua(slugLingua);
    }

    @PostMapping
    public Curso cadastraCurso(@RequestBody Curso curso) {
        return cursoService.cadastrarCurso(curso);
    }

    @PutMapping
    public Curso alterarCurso(@RequestBody Curso curso) {
        return cursoService.alterarCurso(curso);
    }

    @DeleteMapping  ("{idCurso}")   // http://localhost:8080/produtos/1
    public void removerCurso(@PathVariable("idCurso") long id) {
        cursoService.removerCurso(id);
    }

    // Entradas
    // - pagina corrente
    // - tamanho da página
    // Saídas:
    // - total de itens
    // - total de páginas
    // - pagina corrente
    // - itens da página corrente

    // Requisição do tipo GET para
    // http://localhost:8080/produtos/paginacao?pagina=0&tamanho=5&nome=ce
    @GetMapping("paginacao")
    public ResultadoPaginado<Curso> recuperarCursosComPaginacao(
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanho", defaultValue = "5") int tamanho,
            @RequestParam(value = "nome", defaultValue = "") String nome,
            @RequestParam(value= "lingua", defaultValue = "") String lingua,
            @RequestParam(value= "nivel", defaultValue = "") String nivel) {
        Pageable pageable = PageRequest.of(pagina, tamanho);
        Page<Curso> page = cursoService.recuperarCursosComPaginacao(pageable, nome, lingua, nivel);
        ResultadoPaginado<Curso> resultadoPaginado = new ResultadoPaginado<>(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getContent());
        return resultadoPaginado;
    }

    // http://localhost:8080/produtos/lingua/paginacao?pagina=0&tamanho=5&slugLingua=frutas
    @GetMapping("lingua/paginacao")
    public ResultadoPaginado<Curso> recuperarCursosPaginadosPorSlugDaLingua(
            @RequestParam(value = "pagina", defaultValue = "0") int pagina,
            @RequestParam(value = "tamanho", defaultValue = "3") int tamanho,
            @RequestParam(value = "slugLingua", defaultValue = "") String slugLingua) {
        Pageable pageable = PageRequest.of(pagina, tamanho);
        Page<Curso> page = cursoService.recuperarCursosPaginadosPorSlugDaLingua(slugLingua, pageable);
        ResultadoPaginado<Curso> resultadoPaginado = new ResultadoPaginado<>(
                page.getTotalElements(),
                page.getTotalPages(),
                page.getNumber(),
                page.getContent());
        return resultadoPaginado;
    }
}
