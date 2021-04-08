package br.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@Controller
public class ListarController {
	@Autowired
	private ClienteRepository cr;
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)

	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable long id) {
		cr.findById(id).map(record -> {
			cr.deleteById(id);
			return ResponseEntity.ok().build();
		}).orElse(ResponseEntity.notFound().build());
		return "redirect:/listar-clientes";
	}
	
	@GetMapping("/listar-clientes2")
	public ModelAndView recuperarTodosClientes() {
		// busca no banco todo mundo!
		List<Cliente> clientes = cr.findAll(Sort.by("dataNasc")); // <-- ordenação aqui
		// Cria a capsula que vai levar os dada a view (html)
		ModelAndView capsula = new ModelAndView("lista");
		// Coloca os dados dentro da capsula
		capsula.addObject("clientes", clientes);
		return capsula;
	}

}
