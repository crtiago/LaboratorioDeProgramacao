package br.edu.ifsc.lab.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Produto produtoCliente;
	private String descServico;
	private Float valor;
	private String etapa;
	private Tecnico tecnico;
	

	public Servico() {
		
	}


	public Servico(Integer id, Produto produtoCliente, String descServico, Float valor, String etapa, Tecnico tecnico) {
		super();
		this.id = id;
		this.produtoCliente = produtoCliente;
		this.descServico = descServico;
		this.valor = valor;
		this.etapa = etapa;
		this.tecnico = tecnico;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Produto getProdutoCliente() {
		return produtoCliente;
	}


	public void setProdutoCliente(Produto produtoCliente) {
		this.produtoCliente = produtoCliente;
	}


	public String getDescServico() {
		return descServico;
	}


	public void setDescServico(String descServico) {
		this.descServico = descServico;
	}


	public Float getValor() {
		return valor;
	}


	public void setValor(Float valor) {
		this.valor = valor;
	}


	public String getEtapa() {
		return etapa;
	}


	public void setEtapa(String etapa) {
		this.etapa = etapa;
	}


	public Tecnico getTecnico() {
		return tecnico;
	}


	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	
	
}
