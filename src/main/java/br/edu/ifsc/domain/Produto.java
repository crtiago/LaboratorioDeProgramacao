package br.edu.ifsc.domain;

import java.util.ArrayList;
import java.util.List;

public abstract class Produto {

	private Integer idProduto;
	private String marca;
	private String modelo;

	private List<Categoria> categorias = new ArrayList<>();

	public Produto() {

	}

	public Produto(Integer idProduto, String marca, String modelo) {
		super();
		this.idProduto = idProduto;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Integer getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Integer idProduto) {
		this.idProduto = idProduto;
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
