package br.edu.ifsc.lab.domain;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Endereco {
	private Integer idEndereco;
	private String rua;
	private String cep;
	private Integer numero;
	private String bairro;
	
	@ManyToOne()
	@JoinColumn(name = "idCidade")
	private Cidade cidade;
	
	
	public Endereco() {
		
	}

	public Endereco(Integer id, String rua, String cep, Integer numero, String bairro, Cidade cidade) {
		super();
		this.idEndereco = id;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Integer getIdEndereco() {
		return idEndereco;
	}

	public void setIdEndereco(Integer id) {
		this.idEndereco = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getcep() {
		return cep;
	}

	public void setcep(String cEP) {
		cep = cEP;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
