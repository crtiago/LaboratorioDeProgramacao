package br.edu.ifsc.lab.domain;

import br.edu.ifsc.lab.domain.enums.EstadoPagamento;

public abstract class Pagamento {

	private Integer id;
	private Integer estadoPagamento;

	private Venda venda;

	public Pagamento() {

	}

	public Pagamento(Integer id, EstadoPagamento estadoPagamento, Venda venda) {
		super();
		this.id = id;
		this.estadoPagamento = estadoPagamento.getCod();
		this.venda = venda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getEstadoPagamento() {
		return estadoPagamento;
	}

	public void setEstadoPagamento(Integer estadoPagamento) {
		this.estadoPagamento = estadoPagamento;
	}

	public Venda getVenda() {
		return venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}
