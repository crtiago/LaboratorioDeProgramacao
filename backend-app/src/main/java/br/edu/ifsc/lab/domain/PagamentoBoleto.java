package br.edu.ifsc.lab.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

import br.edu.ifsc.lab.domain.enums.EstadoPagamento;

/*
* Classe representando a forma de pagamento que o {@link Usuario} utilizará ao  realizar uma compra {@link Venda}
* Esta classe estende a classe {@link Pagamento}
*/

@Entity
@JsonTypeName("pagamentoBoleto")
public class PagamentoBoleto extends Pagamento {
	private static final long serialVersionUID = 1L;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVencimento;

	@JsonFormat(pattern = "dd/MM/yyyy")
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
