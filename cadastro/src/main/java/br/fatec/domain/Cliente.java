package br.fatec.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente implements Comparable<Cliente> {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(nullable = false)
	private String nome;
	@Column(nullable = false)
	private String telefone;
	@Column(nullable = false)
	private String dataNasc;
	@Column(nullable = false)
	private String genero;
	@Column(nullable = false)
	private String foto;
	@Column()
	private Long numPes;
	@Column()
	private Long numMaos;
	@Column()
	private Long numSobrancelhas;

	public Long getNumPes() {
		return numPes;
	}

	public void setNumPes(Long numPes) {
		this.numPes = numPes;
	}

	public Long getNumMaos() {
		return numMaos;
	}

	public void setNumMaos(Long numMaos) {
		this.numMaos = numMaos;
	}

	public Long getNumSobrancelhas() {
		return numSobrancelhas;
	}

	public void setNumSobrancelhas(Long numSobrancelhas) {
		this.numSobrancelhas = numSobrancelhas;
	}

	public Long getNumCabelos() {
		return numCabelos;
	}

	public void setNumCabelos(Long numCabelos) {
		this.numCabelos = numCabelos;
	}

	@Column()
	private Long numCabelos;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	@Override
	public int compareTo(Cliente outro) {
		String nomeOutro = outro.nome.toLowerCase();
		String nomeAtual = this.nome.toLowerCase();
		return nomeAtual.compareTo(nomeOutro);
	}

}
