package br.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@Controller
public class ListarController {
	@Autowired
	private ClienteRepository cr;
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)
	@GetMapping("/listar-clientes")
	public ModelAndView CadastrarClientes() {
		List<Cliente> clientes = cr.findAll();
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("clientes", clientes);
		return mv;
	
	}
}
