package br.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.fatec.repository.ClienteRepository;

@Controller
public class ListarController {
	@Autowired
	private ClienteRepository cr;
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)
	
	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable long id) {
		   cr.findById(id)
		           .map(record -> {
		               cr.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		   return "redirect:/listar-clientes";
		}
	

}

