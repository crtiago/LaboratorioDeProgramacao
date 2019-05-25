package br.edu.ifsc.lab.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class UsuarioTecnico extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Float salario;
	// private List<Orcamento> orcamentos = new ArrayList<>();
	// private List<Servico> servicos = new ArrayList<>();

	public UsuarioTecnico() {

	}

	public UsuarioTecnico(Integer id, String login, String senha, String nome, String cpf, float salario) {
		super(id, login, senha, nome, cpf);
		this.salario = salario;
	}

	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}
	/*
	 * public List<Orcamento> getOrcamentos() { return orcamentos; } public void
	 * setOrcamentos(List<Orcamento> orcamentos) { this.orcamentos = orcamentos; }
	 * public List<Servico> getServicos() { return servicos; } public void
	 * setServicos(List<Servico> servicos) { this.servicos = servicos; }
	 */

}
