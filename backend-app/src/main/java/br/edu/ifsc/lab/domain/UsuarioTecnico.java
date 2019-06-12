package br.edu.ifsc.lab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("usuarioTecnico")
public class UsuarioTecnico extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	private Float salario;

	@JsonIgnore
	@OneToMany(mappedBy = "usuarioTecnico")
	private List<Servico> servicos = new ArrayList<>();

	public UsuarioTecnico() {

	}

	public UsuarioTecnico(Integer id, String email, String senha, String nome, String cpf, float salario) {
		super(id, email, senha, nome, cpf);
		this.salario = salario;
	}

	@JsonIgnore
	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
