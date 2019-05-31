package br.edu.ifsc.lab.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class ProdutoCliente extends Produto {
	private static final long serialVersionUID = 1L;

	private String defeito;

	@JsonFormat(pattern = "dd/MM/yyyy  HH:mm")
	private Date dataEntrada;

	@JsonFormat(pattern = "dd/MM/yyyy  HH:mm")
	private Date dataSaida;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private UsuarioCliente usuarioCliente;

	@OneToOne(mappedBy = "produtoCliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)	
	private Servico servico;

	public ProdutoCliente() {

	}

	public ProdutoCliente(Integer id, String marca, String modelo, String defeito, Date dataEntrada, Date dataSaida,
			UsuarioCliente usuarioCliente) {
		super(id, marca, modelo);
		this.defeito = defeito;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.usuarioCliente = usuarioCliente;
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

	public UsuarioCliente getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

}
