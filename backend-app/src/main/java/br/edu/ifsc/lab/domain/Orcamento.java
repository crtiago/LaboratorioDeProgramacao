package br.edu.ifsc.lab.domain;

public class Orcamento {

	private Integer id;
	private Produto produtoCliente;
	private Tecnico tecnico;
	private Float valor;

	public Orcamento() {

	}

	public Orcamento(Integer id, Produto produtoCliente, Tecnico tecnico, Float valor) {
		super();
		this.id = id;
		this.setProdutoCliente(produtoCliente);
		this.tecnico = tecnico;
		this.valor = valor;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public Produto getProdutoCliente() {
		return produtoCliente;
	}

	public void setProdutoCliente(Produto produtoCliente) {
		this.produtoCliente = produtoCliente;
	}

}
