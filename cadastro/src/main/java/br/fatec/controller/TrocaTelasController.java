package br.fatec.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@Controller
public class TrocaTelasController {
	
	@Autowired
	private ClienteRepository cr;
	
	
	 @GetMapping("/alterar/{id}")
	    public ModelAndView alterar (@PathVariable("id") Long id) {
	    	ModelAndView mv = new ModelAndView();
	    	mv.setViewName("alterar");
	    	Cliente c = cr.getOne(id);
	    	mv.addObject("cliente", c);
	    	return mv;
	 }
	
	@RequestMapping(method = RequestMethod.GET, path = "/entrar")
	public String login() {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String paginaInicial() {
		return "index";
	}
	@GetMapping("/listar-clientes")
	public ModelAndView CadastrarClientes() {
		List<Cliente> clientes = cr.findAll();
		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("clientes", clientes);
		return mv;
	}
	@RequestMapping(method = RequestMethod.GET, path = "/cadastrar-clientes")
	public String cadastrarClientes() {
		return "cadastro";
	}
}
