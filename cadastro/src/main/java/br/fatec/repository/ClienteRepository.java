package br.fatec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.fatec.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	

}
