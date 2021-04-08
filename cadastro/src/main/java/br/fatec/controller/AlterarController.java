package br.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@Controller
public class AlterarController {
	
	@Autowired
	private ClienteRepository cr;
	
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)
	

	
	@PostMapping("/alterar")
    public ModelAndView alterar(Cliente c) {
    	ModelAndView mv = new ModelAndView();
    	cr.save(c);
    	mv.setViewName("redirect:/listar-clientes");
		return mv;
		

}
}
