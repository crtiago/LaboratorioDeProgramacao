package br.edu.ifsc.lab.domain;

import java.util.Date;

import javax.persistence.Entity;

import br.edu.ifsc.lab.domain.enums.EstadoPagamento;

@Entity
//@PrimaryKeyJoinColumn(name = "id_pagamento")
public class PagamentoBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	private Date dataVencimento;

	private Date dataPagamento;

	public PagamentoBoleto() {

	}

	public PagamentoBoleto(Integer id, EstadoPagamento estadoPagamento, Venda venda, Date dataVencimento,
			Date dataPagamento) {
		super(id, estadoPagamento, venda);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
