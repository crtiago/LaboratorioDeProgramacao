package br.edu.ifsc.lab.dto;

import java.io.Serializable;

public class EnderecoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String rua;
	private String cep;
	private Integer numero;
	private String bairro;
	private Integer cidadeId;
	private Integer cliId;

	public EnderecoDTO() {

	}

	/*public EnderecoDTO(Endereco end) {
		super();
		this.rua = end.getRua();
		this.cep = end.getCep();
		this.numero = end.getNumero();
		this.bairro = end.getBairro();
		this.cidade = end.getCidade();
		this.cli = end.getUsuario();
	}*/

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public Integer getCidadeId() {
		return cidadeId;
	}

	public void setCidadeId(Integer cidadeId) {
		this.cidadeId = cidadeId;
	}

	public Integer getCliId() {
		return cliId;
	}

	public void setCliId(Integer cliId) {
		this.cliId = cliId;
	}

	
}
