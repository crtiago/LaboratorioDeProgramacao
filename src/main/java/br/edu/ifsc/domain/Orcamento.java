package br.edu.ifsc.domain;

public class Orcamento {

	private Integer id;
	//falta a classe produto
	//private Produto produtoCliente;
	private Cliente cliente;
	private Float valor;
	
	//Criar Contrutor com o produto adcionado
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Float getValor() {
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	
	
}
