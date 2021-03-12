package br.fatec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.fatec.domain.Cliente;

@Controller
public class CadastroController {
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)
	@GetMapping("/cadastrar-clientes")
	public String CadastrarClientes() {
		return "cadastro";
	
	}
	@PostMapping("/cadastrar-clientes") // cvs com o input do html ( usar placeholder no input, name(linka o valor do atributo a entrada(a variavel do controler))
	public String CadastrarClientes(Cliente c) {
		return "cadastro";
	}
}
