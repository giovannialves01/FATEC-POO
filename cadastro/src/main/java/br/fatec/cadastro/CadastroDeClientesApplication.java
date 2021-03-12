package br.fatec.cadastro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages= {"br.fatec.controller"})
@SpringBootApplication
public class CadastroDeClientesApplication {

	public static void main(String[] args) {
		SpringApplication.run(CadastroDeClientesApplication.class, args);
	}

}
