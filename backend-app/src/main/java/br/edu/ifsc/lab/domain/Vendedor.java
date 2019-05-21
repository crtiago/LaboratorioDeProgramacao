package br.edu.ifsc.lab.domain;


import javax.persistence.Entity;

@Entity
public class Vendedor extends Usuario  {
	private static final long serialVersionUID = 1L;

	private Float salario;

	//private List<Venda> HistoricoVenda = new ArrayList<>();
	
	
	
	public Vendedor() {
		
	}

	public Vendedor(Integer id,String login, String senha, String nome, String cpf, Float salario) {
		super(id, login, senha, nome, cpf);
		this.salario = salario;
	}
	
	
	
	public Float getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	/*public List<Venda> getHistoricoVenda() {
		return HistoricoVenda;
	}

	public void setHistoricoVenda(List<Venda> historicoVenda) {
		HistoricoVenda = historicoVenda;
	}*/
	
	
	
}
