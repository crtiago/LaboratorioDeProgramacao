package br.edu.ifsc.domain;

import java.util.Date;

import br.edu.ifsc.domain.enums.EstadoPagamento;

public class PagamentoBoleto extends Pagamento {

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
