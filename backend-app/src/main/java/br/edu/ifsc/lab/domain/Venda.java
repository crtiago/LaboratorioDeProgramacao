package br.edu.ifsc.lab.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private UsuarioCliente usuarioCliente;
	private UsuarioVendedor usuarioVendedor;
	private Produto produto;
	private Servico servico;
	private Date dataVenda;
	private Float valorTotal;

	public Venda() {
		
	}

	public Venda(Integer id, UsuarioCliente usuarioCliente, UsuarioVendedor usuarioVendedor, Produto produto, Servico servico, Date dataVenda,
			Float valorTotal) {
		super();
		this.id = id;
		this.usuarioCliente = usuarioCliente;
		this.usuarioVendedor = usuarioVendedor;
		this.produto = produto;
		this.servico = servico;
		this.dataVenda = dataVenda;
		this.valorTotal = valorTotal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UsuarioCliente getCliente() {
		return usuarioCliente;
	}

	public void setCliente(UsuarioCliente usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public UsuarioVendedor getVendedor() {
		return usuarioVendedor;
	}

	public void setVendedor(UsuarioVendedor usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Float valorTotal) {
		this.valorTotal = valorTotal;
	}
	
}
