package br.edu.ifsc.lab.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class UsuarioCliente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	// List<Venda> historicoVendas = new ArrayList<>();

	public UsuarioCliente() {
		super();
	}

	public UsuarioCliente(Integer id, String login, String senha, String nome, String cpf) {
		super(id, login, senha, nome, cpf);
		// TODO Auto-generated constructor stub
	}

	/*
	 * public List<Venda> getHistoricoVendas() { return historicoVendas; }
	 * 
	 * public void setHistoricoVendas(List<Venda> historicoVendas) {
	 * this.historicoVendas = historicoVendas; }
	 */

}
