package br.edu.ifsc.lab.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_produto")
public class ProdutoVenda extends Produto {
	private static final long serialVersionUID = 1L;

	private Double valor;
	private String especificacoes;
	private Integer estoque;

	@ManyToMany

	@JoinTable(name = "PRODUTO_CATEGORIA", joinColumns = @JoinColumn(name = "idProduto"), inverseJoinColumns = @JoinColumn(name = "idCategoria"))
	private List<Categoria> categorias = new ArrayList<>();

	public ProdutoVenda() {

	}

	public ProdutoVenda(Integer idProduto, String marca, String modelo, Double valor, String especificacoes,
			Integer estoque) {
		super(idProduto, marca, modelo);
		this.valor = valor;
		this.especificacoes = especificacoes;
		this.estoque = estoque;
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
