package br.fatec.domain;

public class Cliente {
	private String nome;
	private String telefone;
	private String dataNasc;
	private String genero;
	
	public Cliente(String nome, String telefone, String dataNasc, String genero) {
		this.nome = nome;
		this.telefone = telefone;
		this.dataNasc = dataNasc;
		this.genero = genero;
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
	
	
	
}
