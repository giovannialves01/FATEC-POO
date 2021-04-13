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
	
	@Query(value = "Select SUM(cliente.num_pes) from Cliente", nativeQuery = true)
	Long somaPes();
	
	@Query(value = "Select SUM(cliente.num_maos) from Cliente", nativeQuery = true)
	Long somaMaos();
	
	@Query(value = "Select SUM(cliente.num_sobrancelhas) from Cliente", nativeQuery = true)
	Long somaSobrancelhas();
	
	@Query(value = "Select SUM(cliente.num_cabelos) from Cliente", nativeQuery = true)
	Long somaCabelos();
	
	@Query(value = "Select SUM(cliente.num_pes) from Cliente where genero = 'Feminino'", nativeQuery = true)
	Long somaPesFem();
	
	@Query(value = "Select SUM(cliente.num_maos) from Cliente where genero = 'Feminino'", nativeQuery = true)
	Long somaMaosFem();
	
	@Query(value = "Select SUM(cliente.num_sobrancelhas) from Cliente where genero = 'Feminino'", nativeQuery = true)
	Long somaSobrancelhasFem();
	
	@Query(value = "Select SUM(cliente.num_cabelos) from Cliente where genero = 'Feminino'", nativeQuery = true)
	Long somaCabelosFem();
	
	@Query(value = "Select SUM(cliente.num_pes) from Cliente where genero = 'Masculino'", nativeQuery = true)
	Long somaPesMasc();
	
	@Query(value = "Select SUM(cliente.num_maos) from Cliente where genero = 'Masculino'", nativeQuery = true)
	Long somaMaosMasc();
	
	@Query(value = "Select SUM(cliente.num_sobrancelhas) from Cliente where genero = 'Masculino'", nativeQuery = true)
	Long somaSobrancelhasMasc();
	
	@Query(value = "Select SUM(cliente.num_cabelos) from Cliente where genero = 'Masculino'", nativeQuery = true)
	Long somaCabelosMasc();
}
