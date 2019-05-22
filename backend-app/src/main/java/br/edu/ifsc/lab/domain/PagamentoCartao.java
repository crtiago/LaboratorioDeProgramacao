package br.edu.ifsc.lab.domain;

import br.edu.ifsc.lab.domain.enums.EstadoPagamento;

public class PagamentoCartao extends Pagamento {
	private static final long serialVersionUID = 1L;
	
	private Integer parcelas;

	public PagamentoCartao() {

	}

	public PagamentoCartao(Integer id, EstadoPagamento estadoPagamento, Venda venda, Integer parcelas) {
		super(id, estadoPagamento, venda);
		this.parcelas = parcelas;
	}

	public Integer getParcelas() {
		return parcelas;
	}

	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}

}
