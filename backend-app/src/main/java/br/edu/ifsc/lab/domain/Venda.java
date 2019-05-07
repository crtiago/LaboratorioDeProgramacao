package br.edu.ifsc.lab.domain;

import java.util.Date;

public class Venda {

	private Integer id;
	private Cliente cliente;
	private Vendedor vendedor;
	private Produto produto;
	private Servico servico;
	private Date dataVenda;
	private Float valorTotal;

	public Venda() {
		
	}

	public Venda(Integer id, Cliente cliente, Vendedor vendedor, Produto produto, Servico servico, Date dataVenda,
			Float valorTotal) {
		super();
		this.id = id;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.produto = produto;
		this.servico = servico;
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
	}

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

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
