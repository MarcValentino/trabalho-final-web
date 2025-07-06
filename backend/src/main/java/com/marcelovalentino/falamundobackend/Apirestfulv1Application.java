package com.marcelovalentino.falamundobackend;

import com.marcelovalentino.falamundobackend.model.Carrinho;
import com.marcelovalentino.falamundobackend.model.Lingua;
import com.marcelovalentino.falamundobackend.model.Curso;
import com.marcelovalentino.falamundobackend.model.Usuario;
import com.marcelovalentino.falamundobackend.model.Nivel;
import com.marcelovalentino.falamundobackend.repository.CarrinhoRepository;
import com.marcelovalentino.falamundobackend.repository.CursoRepository;
import com.marcelovalentino.falamundobackend.repository.LinguaRepository;
import com.marcelovalentino.falamundobackend.repository.UsuarioRepository;
import com.marcelovalentino.falamundobackend.repository.NivelRepository;
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
	private LinguaRepository linguaRepository;

	@Autowired
	private CarrinhoRepository carrinhoRepository;

	@Autowired
	private NivelRepository nivelRepository;

	public static void main(String[] args) {
		SpringApplication.run(Apirestfulv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Usuario usuario = new Usuario("admin", "desweb");
		usuarioRepository.save(usuario);

		Usuario usuario2 = new Usuario("usuario", "desweb");
		usuarioRepository.save(usuario2);

		Lingua frances = new Lingua("Francês", "frances");
		linguaRepository.save(frances);

		Lingua ingles = new Lingua("Inglês", "ingles");
		linguaRepository.save(ingles);

		Lingua espanhol = new Lingua("Espanhol", "espanhol");
		linguaRepository.save(espanhol);

		Lingua alemao = new Lingua("Alemão", "alemao");
		linguaRepository.save(alemao);

		Lingua italiano = new Lingua("Italiano", "italiano");
		linguaRepository.save(italiano);

		Nivel basico = new Nivel("Básico");
		nivelRepository.save(basico);
		Nivel intermediario = new Nivel("Intermediário");
		nivelRepository.save(intermediario);
		Nivel avancado = new Nivel("Avançado");
		nivelRepository.save(avancado);

		Curso francesBasico = new Curso(
				"FR",
				"Francês Básico",
				"frances-basico",
				"Curso introdutório de Francês para iniciantes.",
				true,
				30,
				basico,
				BigDecimal.valueOf(499.90),
				LocalDate.of(2023, 4, 26),
				frances);
		cursoRepository.save(francesBasico);

		Curso francesConversacao = new Curso(
				"FR",
				"Francês Conversação",
				"frances-conversacao",
				"Curso focado em conversação para nível intermediário.",
				true,
				20,
				intermediario,
				BigDecimal.valueOf(599.90),
				LocalDate.of(2023, 6, 10),
				frances);
		cursoRepository.save(francesConversacao);

		Curso inglesIntermediario = new Curso(
				"EN",
				"Inglês Intermediário",
				"ingles-intermediario",
				"Aprofunde seus conhecimentos em Inglês.",
				true,
				25,
				intermediario,
				BigDecimal.valueOf(599.90),
				LocalDate.of(2023, 5, 22),
				ingles);
		cursoRepository.save(inglesIntermediario);

		Curso inglesAvancado = new Curso(
				"EN",
				"Inglês Avançado",
				"ingles-avancado",
				"Curso avançado para fluência em Inglês.",
				true,
				15,
				avancado,
				BigDecimal.valueOf(699.90),
				LocalDate.of(2023, 7, 1),
				ingles);
		cursoRepository.save(inglesAvancado);

		Curso espanholAvancado = new Curso(
				"ES",
				"Espanhol Avançado",
				"espanhol-avancado",
				"Curso avançado para fluência em Espanhol.",
				false,
				10,
				avancado,
				BigDecimal.valueOf(699.90),
				LocalDate.of(2023, 3, 24),
				espanhol);
		cursoRepository.save(espanholAvancado);

		Curso espanholBasico = new Curso(
				"ES",
				"Espanhol Básico",
				"espanhol-basico",
				"Curso básico de Espanhol para iniciantes.",
				true,
				35,
				basico,
				BigDecimal.valueOf(399.90),
				LocalDate.of(2023, 2, 10),
				espanhol);
		cursoRepository.save(espanholBasico);

		Curso alemaoBasico = new Curso(
				"DE",
				"Alemão Básico",
				"alemao-basico",
				"Curso introdutório de Alemão para iniciantes.",
				true,
				18,
				basico,
				BigDecimal.valueOf(549.90),
				LocalDate.of(2023, 8, 5),
				alemao);
		cursoRepository.save(alemaoBasico);

		Curso italianoConversacao = new Curso(
				"IT",
				"Italiano Conversação",
				"italiano-conversacao",
				"Curso de conversação em Italiano para nível intermediário.",
				true,
				12,
				intermediario,
				BigDecimal.valueOf(579.90),
				LocalDate.of(2023, 9, 12),
				italiano);
		cursoRepository.save(italianoConversacao);

		Carrinho carrinho = new Carrinho(
				francesBasico,
				usuario
		);
		carrinhoRepository.save(carrinho);
		carrinho = new Carrinho(
				inglesIntermediario,
				usuario
		);
		carrinhoRepository.save(carrinho);
		carrinho = new Carrinho(
				espanholAvancado,
				usuario2
		);
		carrinhoRepository.save(carrinho);
	}
}
