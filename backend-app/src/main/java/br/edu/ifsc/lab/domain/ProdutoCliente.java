package br.edu.ifsc.lab.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import br.edu.ifsc.lab.domain.enums.StatusServico;

@Entity
@PrimaryKeyJoinColumn(name = "id_produto")
public class ProdutoCliente extends Produto {
	private static final long serialVersionUID = 1L;

	private String defeito;
	private Date dataEntrada;
	private Date dataSaida;
	private Integer statusServico;
	private UsuarioCliente cliente;

	public ProdutoCliente() {

	}

	public ProdutoCliente(Integer id, String marca, String modelo, String defeito, Date dataEntrada, Date dataSaida,
			StatusServico statusServico, UsuarioCliente cliente) {
		super(id, marca, modelo);
		this.defeito = defeito;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.statusServico = statusServico.getCod();
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

	public Integer getStatusServico() {
		return statusServico;
	}

	public void setStatusServico(Integer statusServico) {
		this.statusServico = statusServico;
	}

	public UsuarioCliente getCliente() {
		return cliente;
	}

	public void setCliente(UsuarioCliente cliente) {
		this.cliente = cliente;
	}

}
