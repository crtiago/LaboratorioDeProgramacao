package br.edu.ifsc.domain;

import java.util.ArrayList;
import java.util.List;

public class Vendedor extends Usuario{

	private Float salario;

	private List<Venda> HistoricoVenda = new ArrayList<>();
	
	
	
	public Vendedor() {
		
	}

	public Vendedor(String login, String senha, String nome, String cpf, Float salario) {
		super(login, senha, nome, cpf);
		this.salario = salario;
	}
	
	
	
	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	public List<Venda> getHistoricoVenda() {
		return HistoricoVenda;
	}

	public void setHistoricoVenda(List<Venda> historicoVenda) {
		HistoricoVenda = historicoVenda;
	}
	
	
	
}
