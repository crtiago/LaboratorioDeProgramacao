package br.edu.ifsc.lab.domain;

import java.util.Date;

public class ProdutoCliente extends Produto {

	private String defeito;
	private Date dataEntrada;
	private Date dataSaida;
	private Cliente cliente;

	public ProdutoCliente() {

	}

	public ProdutoCliente(Integer id, String marca, String modelo, String defeito, Date dataEntrada,
			Date dataSaida, Cliente cliente) {
		super(id, marca, modelo);
		this.defeito = defeito;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.cliente = cliente;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
