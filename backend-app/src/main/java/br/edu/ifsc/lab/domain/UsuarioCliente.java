package br.edu.ifsc.lab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class UsuarioCliente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "usuarioCliente")
	private List<Venda> vendas = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "usuarioCliente")
	private List<ProdutoCliente> produtoCliente = new ArrayList<>();

	public UsuarioCliente() {
		super();
	}

	public UsuarioCliente(Integer id, String email, String nome, String cpf) {
		super(id, email, nome, cpf);
		// TODO Auto-generated constructor stub
	}

	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public List<ProdutoCliente> getProdutoCliente() {
		return produtoCliente;
	}

	public void setProdutoCliente(List<ProdutoCliente> produtoCliente) {
		this.produtoCliente = produtoCliente;
	}

}
