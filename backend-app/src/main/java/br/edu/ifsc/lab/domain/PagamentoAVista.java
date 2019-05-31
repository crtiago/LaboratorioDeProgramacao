package br.edu.ifsc.lab.domain;

import javax.persistence.Entity;

import br.edu.ifsc.lab.domain.enums.EstadoPagamento;

@Entity
//@PrimaryKeyJoinColumn(name = "id_pagamento")
public class PagamentoAVista extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Double pagamento;

	public PagamentoAVista() {

	}

	public PagamentoAVista(Integer id, EstadoPagamento estadoPagamento, Venda venda, Double pagamento) {
		super(id, estadoPagamento, venda);
		this.pagamento = pagamento;
	}

	public Double getPagamento() {
		return pagamento;
	}

	public void setPagamento(Double pagamento) {
		this.pagamento = pagamento;
	}

}
