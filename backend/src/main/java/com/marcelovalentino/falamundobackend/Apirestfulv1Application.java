package com.marcelovalentino.falamundobackend;

import com.marcelovalentino.falamundobackend.model.Carrinho;
import com.marcelovalentino.falamundobackend.model.Lingua;
import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.repository.CarrinhoRepository;
import com.marcelovalentino.falamundobackend.repository.CursoRepository;
import com.marcelovalentino.falamundobackend.repository.LinguaRepository;
import com.marcelovalentino.falamundobackend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class Apirestfulv1Application implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private LinguaRepository categoriaRepository;

	@Autowired
	private CarrinhoRepository carrinhoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Apirestfulv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = new Usuario("admin", "desweb");
		usuarioRepository.save(usuario);

		Usuario usuario2 = new Usuario("usuario", "desweb");
		usuarioRepository.save(usuario2);

		Lingua fruta = new Lingua("Fruta", "frutas");
		categoriaRepository.save(fruta);

		Lingua legume = new Lingua("Legume", "legumes");
		categoriaRepository.save(legume);

		Lingua verdura = new Lingua("Verdura", "verduras");
		categoriaRepository.save(verdura);



		Curso curso = new Curso(
				"abacate.png",
				"Abacate",
				"abacate",
				"1 unidade aprox. 750g",
				true,
				100,
				BigDecimal.valueOf(2.45),
				LocalDate.of(2023, 4, 26),
				fruta);
		cursoRepository.save(curso);

		Carrinho carrinho = new Carrinho(
				curso,
				usuario
		);
		curso = new Curso(
				"abobrinha.png",
				"Abobrinha",
				"abobrinha",
				"1 unidade aprox. 250g",
				false,
				500,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobora.png",
				"Abóbora",
				"abobora",
				"1 unidade aprox. 1,9kg",
				true,
				400,
				BigDecimal.valueOf(4.7),
				LocalDate.of(2023, 3, 24),
				legume);
		cursoRepository.save(curso);

		carrinhoRepository.save(new Carrinho(
				curso,
				usuario
		));
		curso = new Curso(
				"acelga.png",
				"Acelga",
				"acelga",
				"1 maço de aprox. 400g",
				true,
				120,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 3, 12),
				verdura);
		cursoRepository.save(curso);
		carrinho = new Carrinho(
				curso,
				usuario
		);
		carrinhoRepository.save(carrinho);
		curso = new Curso(
				"agriao.png",
				"Agrião",
				"agriao",
				"1 maço de aprox. 200g",
				true,
				340,
				BigDecimal.valueOf(2.5),
				LocalDate.of(2023, 5, 17),
				verdura);
		cursoRepository.save(curso);
		carrinho = new Carrinho(
				curso,
				usuario,
				true
		);
		carrinhoRepository.save(carrinho);
		curso = new Curso(
				"alface.png",
				"Alface",
				"alface",
				"1 maço de aprox. 200g",
				true,
				220,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 5, 14),
				verdura);
		cursoRepository.save(curso);
		carrinho = new Carrinho(
				curso,
				usuario2
		);
		carrinhoRepository.save(carrinho);
		curso = new Curso(
				"banana.png",
				"Banana",
				"banana",
				"1 unidade aprox. 165g",
				true,
				350,
				BigDecimal.valueOf(1.05),
				LocalDate.of(2023, 2, 22),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"beringela.png",
				"Beringela",
				"beringela",
				"1 unidade aprox. 370g",
				true,
				720,
				BigDecimal.valueOf(1.85),
				LocalDate.of(2023, 2, 23),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"brocolis.png",
				"Brócolis",
				"brocolis",
				"1 unidade aprox. 300g",
				true,
				600,
				BigDecimal.valueOf(5.39),
				LocalDate.of(2023, 3, 28),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"cebola.png",
				"Cebola",
				"cebola",
				"1 unidade aprox. 200g",
				true,
				95,
				BigDecimal.valueOf(0.56),
				LocalDate.of(2023, 4, 30),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cenoura.png",
				"Cenoura",
				"cenoura",
				"1 unidade aprox. 180g",
				true,
				350,
				BigDecimal.valueOf(1.01),
				LocalDate.of(2023, 5, 29),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cereja.png",
				"Cereja",
				"cereja",
				"1 unidade aprox. 250g",
				true,
				240,
				BigDecimal.valueOf(11.23),
				LocalDate.of(2023, 5, 11),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abacate.png",
				"Abacate",
				"abacate",
				"1 unidade aprox. 750g",
				true,
				100,
				BigDecimal.valueOf(2.45),
				LocalDate.of(2023, 4, 26),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobrinha.png",
				"Abobrinha",
				"abobrinha",
				"1 unidade aprox. 250g",
				false,
				500,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobora.png",
				"Abóbora",
				"abobora",
				"1 unidade aprox. 1,9kg",
				true,
				400,
				BigDecimal.valueOf(4.7),
				LocalDate.of(2023, 3, 24),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"acelga.png",
				"Acelga",
				"acelga",
				"1 maço de aprox. 400g",
				true,
				120,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 3, 12),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"agriao.png",
				"Agrião",
				"agriao",
				"1 maço de aprox. 200g",
				true,
				340,
				BigDecimal.valueOf(2.5),
				LocalDate.of(2023, 5, 17),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"alface.png",
				"Alface",
				"alface",
				"1 maço de aprox. 200g",
				true,
				220,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 5, 14),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"banana.png",
				"Banana",
				"banana",
				"1 unidade aprox. 165g",
				true,
				350,
				BigDecimal.valueOf(1.05),
				LocalDate.of(2023, 2, 22),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"beringela.png",
				"Beringela",
				"beringela",
				"1 unidade aprox. 370g",
				true,
				720,
				BigDecimal.valueOf(1.85),
				LocalDate.of(2023, 2, 23),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"brocolis.png",
				"Brócolis",
				"brocolis",
				"1 unidade aprox. 300g",
				true,
				600,
				BigDecimal.valueOf(5.39),
				LocalDate.of(2023, 3, 28),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"cebola.png",
				"Cebola",
				"cebola",
				"1 unidade aprox. 200g",
				true,
				95,
				BigDecimal.valueOf(0.56),
				LocalDate.of(2023, 4, 30),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cenoura.png",
				"Cenoura",
				"cenoura",
				"1 unidade aprox. 180g",
				true,
				350,
				BigDecimal.valueOf(1.01),
				LocalDate.of(2023, 5, 29),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cereja.png",
				"Cereja",
				"cereja",
				"1 unidade aprox. 250g",
				true,
				240,
				BigDecimal.valueOf(11.23),
				LocalDate.of(2023, 5, 11),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abacate.png",
				"Abacate",
				"abacate",
				"1 unidade aprox. 750g",
				true,
				100,
				BigDecimal.valueOf(2.45),
				LocalDate.of(2023, 4, 26),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobrinha.png",
				"Abobrinha",
				"abobrinha",
				"1 unidade aprox. 250g",
				false,
				500,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobora.png",
				"Abóbora",
				"abobora",
				"1 unidade aprox. 1,9kg",
				true,
				400,
				BigDecimal.valueOf(4.7),
				LocalDate.of(2023, 3, 24),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"acelga.png",
				"Acelga",
				"acelga",
				"1 maço de aprox. 400g",
				true,
				120,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 3, 12),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"agriao.png",
				"Agrião",
				"agriao",
				"1 maço de aprox. 200g",
				true,
				340,
				BigDecimal.valueOf(2.5),
				LocalDate.of(2023, 5, 17),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"alface.png",
				"Alface",
				"alface",
				"1 maço de aprox. 200g",
				true,
				220,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 5, 14),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"banana.png",
				"Banana",
				"banana",
				"1 unidade aprox. 165g",
				true,
				350,
				BigDecimal.valueOf(1.05),
				LocalDate.of(2023, 2, 22),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"beringela.png",
				"Beringela",
				"beringela",
				"1 unidade aprox. 370g",
				true,
				720,
				BigDecimal.valueOf(1.85),
				LocalDate.of(2023, 2, 23),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"brocolis.png",
				"Brócolis",
				"brocolis",
				"1 unidade aprox. 300g",
				true,
				600,
				BigDecimal.valueOf(5.39),
				LocalDate.of(2023, 3, 28),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"cebola.png",
				"Cebola",
				"cebola",
				"1 unidade aprox. 200g",
				true,
				95,
				BigDecimal.valueOf(0.56),
				LocalDate.of(2023, 4, 30),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cenoura.png",
				"Cenoura",
				"cenoura",
				"1 unidade aprox. 180g",
				true,
				350,
				BigDecimal.valueOf(1.01),
				LocalDate.of(2023, 5, 29),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cereja.png",
				"Cereja",
				"cereja",
				"1 unidade aprox. 250g",
				true,
				240,
				BigDecimal.valueOf(11.23),
				LocalDate.of(2023, 5, 11),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abacate.png",
				"Abacate",
				"abacate",
				"1 unidade aprox. 750g",
				true,
				100,
				BigDecimal.valueOf(2.45),
				LocalDate.of(2023, 4, 26),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobrinha.png",
				"Abobrinha",
				"abobrinha",
				"1 unidade aprox. 250g",
				false,
				500,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobora.png",
				"Abóbora",
				"abobora",
				"1 unidade aprox. 1,9kg",
				true,
				400,
				BigDecimal.valueOf(4.7),
				LocalDate.of(2023, 3, 24),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"acelga.png",
				"Acelga",
				"acelga",
				"1 maço de aprox. 400g",
				true,
				120,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 3, 12),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"agriao.png",
				"Agrião",
				"agriao",
				"1 maço de aprox. 200g",
				true,
				340,
				BigDecimal.valueOf(2.5),
				LocalDate.of(2023, 5, 17),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"alface.png",
				"Alface",
				"alface",
				"1 maço de aprox. 200g",
				true,
				220,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 5, 14),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"banana.png",
				"Banana",
				"banana",
				"1 unidade aprox. 165g",
				true,
				350,
				BigDecimal.valueOf(1.05),
				LocalDate.of(2023, 2, 22),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"beringela.png",
				"Beringela",
				"beringela",
				"1 unidade aprox. 370g",
				true,
				720,
				BigDecimal.valueOf(1.85),
				LocalDate.of(2023, 2, 23),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"brocolis.png",
				"Brócolis",
				"brocolis",
				"1 unidade aprox. 300g",
				true,
				600,
				BigDecimal.valueOf(5.39),
				LocalDate.of(2023, 3, 28),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"cebola.png",
				"Cebola",
				"cebola",
				"1 unidade aprox. 200g",
				true,
				95,
				BigDecimal.valueOf(0.56),
				LocalDate.of(2023, 4, 30),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cenoura.png",
				"Cenoura",
				"cenoura",
				"1 unidade aprox. 180g",
				true,
				350,
				BigDecimal.valueOf(1.01),
				LocalDate.of(2023, 5, 29),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cereja.png",
				"Cereja",
				"cereja",
				"1 unidade aprox. 250g",
				true,
				240,
				BigDecimal.valueOf(11.23),
				LocalDate.of(2023, 5, 11),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abacate.png",
				"Abacate",
				"abacate",
				"1 unidade aprox. 750g",
				true,
				100,
				BigDecimal.valueOf(2.45),
				LocalDate.of(2023, 4, 26),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobrinha.png",
				"Abobrinha",
				"abobrinha",
				"1 unidade aprox. 250g",
				false,
				500,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobora.png",
				"Abóbora",
				"abobora",
				"1 unidade aprox. 1,9kg",
				true,
				400,
				BigDecimal.valueOf(4.7),
				LocalDate.of(2023, 3, 24),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"acelga.png",
				"Acelga",
				"acelga",
				"1 maço de aprox. 400g",
				true,
				120,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 3, 12),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"agriao.png",
				"Agrião",
				"agriao",
				"1 maço de aprox. 200g",
				true,
				340,
				BigDecimal.valueOf(2.5),
				LocalDate.of(2023, 5, 17),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"alface.png",
				"Alface",
				"alface",
				"1 maço de aprox. 200g",
				true,
				220,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 5, 14),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"banana.png",
				"Banana",
				"banana",
				"1 unidade aprox. 165g",
				true,
				350,
				BigDecimal.valueOf(1.05),
				LocalDate.of(2023, 2, 22),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"beringela.png",
				"Beringela",
				"beringela",
				"1 unidade aprox. 370g",
				true,
				720,
				BigDecimal.valueOf(1.85),
				LocalDate.of(2023, 2, 23),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"brocolis.png",
				"Brócolis",
				"brocolis",
				"1 unidade aprox. 300g",
				true,
				600,
				BigDecimal.valueOf(5.39),
				LocalDate.of(2023, 3, 28),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"cebola.png",
				"Cebola",
				"cebola",
				"1 unidade aprox. 200g",
				true,
				95,
				BigDecimal.valueOf(0.56),
				LocalDate.of(2023, 4, 30),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cenoura.png",
				"Cenoura",
				"cenoura",
				"1 unidade aprox. 180g",
				true,
				350,
				BigDecimal.valueOf(1.01),
				LocalDate.of(2023, 5, 29),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cereja.png",
				"Cereja",
				"cereja",
				"1 unidade aprox. 250g",
				true,
				240,
				BigDecimal.valueOf(11.23),
				LocalDate.of(2023, 5, 11),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abacate.png",
				"Abacate",
				"abacate",
				"1 unidade aprox. 750g",
				true,
				100,
				BigDecimal.valueOf(2.45),
				LocalDate.of(2023, 4, 26),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobrinha.png",
				"Abobrinha",
				"abobrinha",
				"1 unidade aprox. 250g",
				false,
				500,
				BigDecimal.valueOf(1.1),
				LocalDate.of(2023, 5, 22),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"abobora.png",
				"Abóbora",
				"abobora",
				"1 unidade aprox. 1,9kg",
				true,
				400,
				BigDecimal.valueOf(4.7),
				LocalDate.of(2023, 3, 24),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"acelga.png",
				"Acelga",
				"acelga",
				"1 maço de aprox. 400g",
				true,
				120,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 3, 12),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"agriao.png",
				"Agrião",
				"agriao",
				"1 maço de aprox. 200g",
				true,
				340,
				BigDecimal.valueOf(2.5),
				LocalDate.of(2023, 5, 17),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"alface.png",
				"Alface",
				"alface",
				"1 maço de aprox. 200g",
				true,
				220,
				BigDecimal.valueOf(4.99),
				LocalDate.of(2023, 5, 14),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"banana.png",
				"Banana",
				"banana",
				"1 unidade aprox. 165g",
				true,
				350,
				BigDecimal.valueOf(1.05),
				LocalDate.of(2023, 2, 22),
				fruta);
		cursoRepository.save(curso);

		curso = new Curso(
				"beringela.png",
				"Beringela",
				"beringela",
				"1 unidade aprox. 370g",
				true,
				720,
				BigDecimal.valueOf(1.85),
				LocalDate.of(2023, 2, 23),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"brocolis.png",
				"Brócolis",
				"brocolis",
				"1 unidade aprox. 300g",
				true,
				600,
				BigDecimal.valueOf(5.39),
				LocalDate.of(2023, 3, 28),
				verdura);
		cursoRepository.save(curso);

		curso = new Curso(
				"cebola.png",
				"Cebola",
				"cebola",
				"1 unidade aprox. 200g",
				true,
				95,
				BigDecimal.valueOf(0.56),
				LocalDate.of(2023, 4, 30),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cenoura.png",
				"Cenoura",
				"cenoura",
				"1 unidade aprox. 180g",
				true,
				350,
				BigDecimal.valueOf(1.01),
				LocalDate.of(2023, 5, 29),
				legume);
		cursoRepository.save(curso);

		curso = new Curso(
				"cereja.png",
				"Cereja",
				"cereja",
				"1 unidade aprox. 250g",
				true,
				240,
				BigDecimal.valueOf(11.23),
				LocalDate.of(2023, 5, 11),
				fruta);
		cursoRepository.save(curso);

	}
}
