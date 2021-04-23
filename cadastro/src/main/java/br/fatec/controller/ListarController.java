package br.fatec.controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
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
	
	GregorianCalendar gc = new GregorianCalendar();
	
	@GetMapping("/excluir/{id}")
	public String delete(@PathVariable long id) {
		   cr.findById(id)
		           .map(record -> {
		               cr.deleteById(id);
		               return ResponseEntity.ok().build();
		           }).orElse(ResponseEntity.notFound().build());
		   return "redirect:/listar-clientes";
		}
	
	@GetMapping("/listar-clientes-nome")
	public ModelAndView todosClientesOrdenadoPorNome() {
		List<Cliente> clientes = cr.findAll(Sort.by("nome")); // <-- ordenação aqui
		ModelAndView capsula = new ModelAndView("lista");
		capsula.addObject("clientes", clientes);
		Long media = 0L;
		for (String idade : cr.idadesTodosCadastrados()) {
			media += Long.valueOf(idade);
		}
		if(media != 0) {
			media = media/cr.idadesTodosCadastrados().size();
			media = gc.get(Calendar.YEAR) - media;
			capsula.addObject("idades", media);
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
		capsula.addObject("servicoMaisPedido", maisPedido);
		}
		return capsula;
}
	@GetMapping("/listar-clientes-masculinos")
	public ModelAndView todosClientesOrdenadoPorGeneroMasc() {
		ModelAndView capsula = new ModelAndView("lista");
		capsula.addObject("clientes", cr.getMasc());
		Long media = 0L;
		for (String idade : cr.idadesTodosHomensCadastrados()) {
			media += Long.valueOf(idade);
		}
		if(media != 0) {
			media = media/cr.idadesTodosHomensCadastrados().size();
			media = gc.get(Calendar.YEAR) - media;
			capsula.addObject("idades", media);
		}
		String maisPedido;
		if(cr.somaMaosMasc() != null) {
			if(cr.somaMaosMasc() >= cr.somaPesMasc() && cr.somaMaosMasc() >= cr.somaSobrancelhasMasc() && cr.somaMaosMasc() >= cr.somaCabelosMasc()) {
				maisPedido = "Serviço de manicure";
			}
			else if(cr.somaPesMasc() >= cr.somaMaosMasc() && cr.somaPesMasc() >= cr.somaSobrancelhasMasc() && cr.somaPesMasc() >= cr.somaCabelosMasc()) {
				maisPedido = "Serviço de pedicure";
			}
			else if(cr.somaSobrancelhasMasc() >= cr.somaMaosMasc() && cr.somaSobrancelhasMasc() >= cr.somaPesMasc() && cr.somaSobrancelhasMasc() >= cr.somaCabelosMasc()) {
				maisPedido = "Serviço de sobrancelhas";
			}
			else {
				maisPedido = "Serviço de cabelereiro";
			}
			capsula.addObject("servicoMaisPedido", maisPedido);
		}
		return capsula;
}
	@GetMapping("/listar-clientes-femininos")
	public ModelAndView todosClientesOrdenadoPorGeneroFem() {
		ModelAndView capsula = new ModelAndView("lista");
		capsula.addObject("clientes", cr.getFem());
		Long media = 0L;
		for (String idade : cr.idadesTodosMulheresCadastrados()) {
			media += Long.valueOf(idade);
		}
		if(media != 0) {
			media = media/cr.idadesTodosMulheresCadastrados().size();
			media = gc.get(Calendar.YEAR) - media;
			capsula.addObject("idades", media);
		}
		String maisPedido;
		if(cr.somaMaosFem() != null) {
			if(cr.somaMaosFem() == 0 && cr.somaPesFem() == 0 && cr.somaSobrancelhasFem() == 0 && cr.somaCabelosFem() == 0) {
				maisPedido = "Sem resultados";
			}
			if(cr.somaMaosFem() >= cr.somaPesFem() && cr.somaMaosFem() >= cr.somaSobrancelhasFem() && cr.somaMaosFem() >= cr.somaCabelosFem()) {
				maisPedido = "Serviço de manicure";
			}
			else if(cr.somaPesFem() >= cr.somaMaosFem() && cr.somaPesFem() >= cr.somaSobrancelhasFem() && cr.somaPesFem() >= cr.somaCabelosFem()) {
				maisPedido = "Serviço de pedicure";
			}
			else if(cr.somaSobrancelhasFem() >= cr.somaMaosFem() && cr.somaSobrancelhasFem() >= cr.somaPesFem() && cr.somaSobrancelhasFem() >= cr.somaCabelosFem()) {
				maisPedido = "Serviço de sobrancelhas";
			}
			else {
				maisPedido = "Serviço de cabelereiro";
			}
			capsula.addObject("servicoMaisPedido", maisPedido);
		}
		return capsula;
}
}
