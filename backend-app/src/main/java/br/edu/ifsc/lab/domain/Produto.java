package br.edu.ifsc.lab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public abstract class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;

	@ManyToMany
	@JoinTable(
			name = "PRODUTO_CATEGORIA",
			joinColumns = @JoinColumn(name = "idProduto"),
			inverseJoinColumns = @JoinColumn(name = "idCategoria")
		)
	private List<Categoria> categorias = new ArrayList<>();

	public Produto() {

	}

	public Produto(Integer idProduto, String marca, String modelo) {
		super();
		this.id = idProduto;
		this.marca = marca;
		this.modelo = modelo;
	}

	public Integer getIdProduto() {
		return id;
	}

	public void setIdProduto(Integer idProduto) {
		this.id = idProduto;
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
