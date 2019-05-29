package br.edu.ifsc.lab.domain;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class UsuarioVendedor extends Usuario {
	private static final long serialVersionUID = 1L;

	private Float salario;

	// private List<Venda> HistoricoVenda = new ArrayList<>();

	public UsuarioVendedor() {

	}

	public UsuarioVendedor(Integer id, String email, String nome, String cpf, Float salario) {
		super(id, email, nome, cpf);
		this.salario = salario;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	/*
	 * public List<Venda> getHistoricoVenda() { return HistoricoVenda; }
	 * 
	 * public void setHistoricoVenda(List<Venda> historicoVenda) { HistoricoVenda =
	 * historicoVenda; }
	 */

}
