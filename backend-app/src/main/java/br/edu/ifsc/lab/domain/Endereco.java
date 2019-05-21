package br.edu.ifsc.lab.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String rua;
	private String cep;
	private Integer numero;
	private String bairro;
	
	@ManyToOne()
	@JoinColumn(name = "idCidade")
	private Cidade cidade;
	
	
	private Usuario usuario;
	
	public Endereco() {
		
	}

	public Endereco(Integer id, String rua, String cep, Integer numero, String bairro, Cidade cidade) {
		super();
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Integer getIdEndereco() {
		return id;
	}

	public void setIdEndereco(Integer id) {
		this.id = id;
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
