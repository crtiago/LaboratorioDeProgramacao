package br.edu.ifsc.lab.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.edu.ifsc.lab.domain.ItemVenda;
import br.edu.ifsc.lab.domain.Pagamento;
import br.edu.ifsc.lab.domain.Servico;
import br.edu.ifsc.lab.domain.Venda;

public class VendaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "GMT-3")
	private Date dataVenda;

	private Pagamento pagamento;

	private Integer usuarioCliente;

	private Set<ItemVenda> itens = new HashSet<>();

	private List<Servico> servico = new ArrayList<>();

	public VendaDTO() {

	}

	public VendaDTO(Venda venda) {
		super();
		this.id = venda.getId();
		this.dataVenda = venda.getDataVenda();
		this.usuarioCliente = venda.getUsuarioCliente().getId_usuario();
		this.pagamento = venda.getPagamento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Integer getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(Integer usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public Set<ItemVenda> getItens() {
		return itens;
	}

	public void setItens(Set<ItemVenda> itens) {
		this.itens = itens;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

}
