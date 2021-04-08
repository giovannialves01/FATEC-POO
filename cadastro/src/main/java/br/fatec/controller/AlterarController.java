package br.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@RestController
public class AlterarController {
	@Autowired
	private ClienteRepository cr;
	CadastroController cc = new CadastroController();
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)
	

	
	@PostMapping("/alterar")
    public ModelAndView alterar(Cliente c) {
    	ModelAndView mv = new ModelAndView();
    	cr.save(c);
    	mv.setViewName("redirect:/listar-clientes");
		return mv;
		

}
}
