package br.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@Controller
public class QuantidadePedidosController {
	
	@Autowired
	private ClienteRepository cr;
	
	Cliente c = new Cliente();
	
	public void aumentarQuantidadePedidosFeitos(Long id) {
		Cliente c = cr.getOne(id);
		c.getNumCabelos();
		return ;
	}
}
