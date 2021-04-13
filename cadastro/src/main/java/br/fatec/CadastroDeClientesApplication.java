package br.fatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.fatec.repository.ClienteRepository;


@SpringBootApplication
public class CadastroDeClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeClientesApplication.class, args);
	}

}
