package br.edu.ifsc.domain;

import br.edu.ifsc.domain.enums.EstadoPagamento;

public class PagamentoAVista extends Pagamento {

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
