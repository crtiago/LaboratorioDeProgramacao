package br.edu.ifsc.domain;

public class Endereco {
	private Integer id;
	private String rua;
	private String cep;
	private Integer numero;
	private String bairro;
	
	private Cidade cidade;
	
	public Endereco() {
		
	}

	public Endereco(Integer id, String rua, String cep, Integer numero, String bairro, Cidade cidade) {
		super();
		this.id = id;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getcep() {
		return cep;
	}

	public void setcep(String cEP) {
		cep = cEP;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	
	

}
