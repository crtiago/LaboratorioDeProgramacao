package br.edu.ifsc.lab.domain;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonTypeName;

import br.edu.ifsc.lab.domain.enums.EstadoPagamento;

/*
* Classe representando a forma de pagamento que o {@link Usuario} utilizará ao  realizar uma compra {@link Venda}
* Esta classe estende a classe {@link Pagamento}
*/

@Entity
@JsonTypeName("pagamentoCartao")
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
