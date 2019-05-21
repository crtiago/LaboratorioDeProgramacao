package br.edu.ifsc.lab.domain;

public class ProdutoVenda extends Produto {

	private Double valor;
	private String especificacoes;
	private Integer estoque;

	public ProdutoVenda() {

	}

	public ProdutoVenda(Integer id, String marca, String modelo, Double valor, String especificacoes,
			Integer estoque) {
		super(id, marca, modelo);
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

}
