package br.edu.ifsc.lab.domain;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {
	
	List<Venda> historicoVendas = new ArrayList<>();

	
	public Cliente() {
		super();
	}











	public Cliente(String login, String senha, String nome, String cpf) {
		super(login, senha, nome, cpf);
		// TODO Auto-generated constructor stub
	}











	public List<Venda> getHistoricoVendas() {
		return historicoVendas;
	}

	public void setHistoricoVendas(List<Venda> historicoVendas) {
		this.historicoVendas = historicoVendas;
	}
	
	
}
