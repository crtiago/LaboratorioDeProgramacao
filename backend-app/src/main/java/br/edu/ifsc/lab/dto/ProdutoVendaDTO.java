package br.edu.ifsc.lab.dto;

import java.io.Serializable;

import br.edu.ifsc.lab.domain.Produto;

public class ProdutoVendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String marca;
	private String modelo;
	private Double valor;
	private String especificacoes;
	private Integer estoque;

	public ProdutoVendaDTO(Produto prod) {
		this.id = prod.getIdProduto();
		this.marca = prod.getMarca();
		this.modelo = prod.getModelo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getEspecificacoes() {
		return especificacoes;
	}

	public void setEspecificacoes(String especificacoes) {
		this.especificacoes = especificacoes;
	}

	public Integer getEstoque() {
		return estoque;
	}

	public void setEstoque(Integer estoque) {
		this.estoque = estoque;
	}

}
