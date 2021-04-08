package br.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@RestController
public class ControleRestController {
	@Autowired
	private ClienteRepository cr;
	
	@GetMapping("/listar-cliente-rest")
	public List<Cliente> clientes(){
		List<Cliente> clientes = cr.findAll(Sort.by("nome"));
		return clientes;
	}
}
