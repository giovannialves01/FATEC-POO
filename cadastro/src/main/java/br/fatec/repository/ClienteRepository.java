package br.fatec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.fatec.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	@Query("Select substring (dataNasc, 7,4) as ExtractString from Cliente")
	List<String> idadesTodosCadastrados();
	
	@Query("Select substring (dataNasc, 7,4) as ExtractString from Cliente where genero = 'Feminino'")
	List<String> idadesTodosMulheresCadastrados();
	
	@Query("Select substring (dataNasc, 7,4) as ExtractString from Cliente where genero = 'Masculino'")
	List<String> idadesTodosHomensCadastrados();
		
	@Query(value = "Select * from Cliente where genero = 'Masculino'", nativeQuery = true)
	List<Cliente> getMasc();
	
	@Query(value = "Select * from Cliente where genero = 'Feminino'", nativeQuery = true)
	List<Cliente> getFem();
}
