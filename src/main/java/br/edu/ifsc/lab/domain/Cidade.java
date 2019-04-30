package br.edu.ifsc.lab.domain;

import javax.persistence.Entity;

@Entity
public class Cidade {

	private Integer idCidade;
	private String nome;
	
	public Cidade() {
		
	}

	public Cidade(Integer id, String nome) {
		super();
		this.idCidade = id;
		this.nome = nome;
	}

	public Integer getIdCidade() {
		return idCidade;
	}

	public void setIdCidade(Integer id) {
		this.idCidade = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
