package br.fatec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CadastroController {
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)
	@GetMapping("/cadastro")
	public String Cadastro() {
		return "cadastro";
	}
	@PostMapping("/cadastro") // cvs com o input do html ( usar placeholder no input, name(linka o valor do atributo a entrada(a variavel do controler))

	}
}
