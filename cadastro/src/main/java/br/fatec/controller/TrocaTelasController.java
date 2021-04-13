package br.fatec.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
	
	GregorianCalendar gc = new GregorianCalendar();
	
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
		Long media = 0L;
		for (String idade : cr.idadesTodosCadastrados()) {
			media += Long.valueOf(idade);
		}
		if(media != 0) {
		media = media/cr.idadesTodosCadastrados().size();
		media = gc.get(Calendar.YEAR) - media;
		mv.addObject("idades", media);
		}
		String maisPedido;
		if(cr.somaMaosMasc() != null) {
		if(cr.somaMaos() >= cr.somaPes() && cr.somaMaos() >= cr.somaSobrancelhas() && cr.somaMaos() >= cr.somaCabelos()) {
			maisPedido = "Serviço de manicure";
		}
		else if(cr.somaPes() >= cr.somaMaos() && cr.somaPes() >= cr.somaSobrancelhas() && cr.somaPes() >= cr.somaCabelos()) {
			maisPedido = "Serviço de pedicure";
		}
		else if(cr.somaSobrancelhas() >= cr.somaMaos() && cr.somaSobrancelhas() >= cr.somaPes() && cr.somaSobrancelhas() >= cr.somaCabelos()) {
			maisPedido = "Serviço de sobrancelhas";
		}
		else {
			maisPedido = "Serviço de cabelereiro";
		}
		mv.addObject("servicoMaisPedido", maisPedido);
		}
		return mv;
		}
	
	@RequestMapping(method = RequestMethod.GET, path = "/cadastrar-clientes")
	public String cadastrarClientes() {
		return "cadastro";
	}
}
