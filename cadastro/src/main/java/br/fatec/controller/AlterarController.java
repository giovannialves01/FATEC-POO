package br.fatec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.fatec.domain.Cliente;
import br.fatec.repository.ClienteRepository;

@Controller
public class AlterarController {
	@Autowired
	private ClienteRepository cr;
	CadastroController cc = new CadastroController();
	// pojo - plain old java object (simples variaveis privadas e metodos set e get)
	

	
	@RequestMapping(value="/alterar", method= RequestMethod.POST)
	public String alterar (@PathVariable long id, @RequestBody Cliente c) {
		
		cr.findById(id).map(record -> { 
			record.setId(c.getId());
			record.setNome(c.getNome());
			record.setTelefone(c.getTelefone());
			record.setDataNasc(c.getDataNasc());
			record.setGenero(c.getGenero());
			record.setNumPes(c.getNumPes());
			record.setNumMaos(c.getNumMaos());
			record.setNumSobrancelhas(c.getNumSobrancelhas());
			record.setNumCabelos(c.getNumCabelos());
			Cliente updated = cr.save(record);
			return ResponseEntity.ok().body(updated);});
		 return "redirect:/listar-clientes";
		

}
}
