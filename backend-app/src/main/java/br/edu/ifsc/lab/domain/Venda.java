package br.edu.ifsc.lab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy  HH:mm")
	private Date dataVenda;

	@ManyToOne
	@JoinColumn(name = "vendedor_id")
	private UsuarioVendedor usuarioVendedor;

	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private UsuarioCliente usuarioCliente;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "venda")
	private Pagamento pagamento;

	@OneToMany(mappedBy = "id.venda")
	private Set<ItemVenda> itens = new HashSet<>();

	@OneToMany(mappedBy = "venda")
	private List<Servico> servico = new ArrayList<>();

	public Venda() {

	}

	public Venda(Integer id, UsuarioCliente usuarioCliente, UsuarioVendedor usuarioVendedor, Date dataVenda) {
		super();
		this.id = id;
		this.usuarioCliente = usuarioCliente;
		this.usuarioVendedor = usuarioVendedor;
		this.dataVenda = dataVenda;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
	public UsuarioCliente getCliente() {
		return usuarioCliente;
	}

	public void setCliente(UsuarioCliente usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	@JsonIgnore
	public UsuarioVendedor getVendedor() {
		return usuarioVendedor;
	}

	public void setVendedor(UsuarioVendedor usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}

	public Date getDataVenda() {
		return dataVenda;
	}

	public void setDataVenda(Date dataVenda) {
		this.dataVenda = dataVenda;
	}

	public Float getValorTotal() {
		float valorTotal = (float) 0;
		for (ItemVenda itemVenda : itens) {
			valorTotal = valorTotal + itemVenda.getSubTotal();
		}

		for (Servico servico : servico) {
			valorTotal = valorTotal + servico.getValor();
		}
		return valorTotal;
	}

	public UsuarioCliente getUsuarioCliente() {
		return usuarioCliente;
	}

	public void setUsuarioCliente(UsuarioCliente usuarioCliente) {
		this.usuarioCliente = usuarioCliente;
	}

	public UsuarioVendedor getUsuarioVendedor() {
		return usuarioVendedor;
	}

	public void setUsuarioVendedor(UsuarioVendedor usuarioVendedor) {
		this.usuarioVendedor = usuarioVendedor;
	}

	public Pagamento getPagamento() {
		return pagamento;
	}

	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}

	public Set<ItemVenda> getItens() {
		return itens;
	}

	public List<Servico> getServico() {
		return servico;
	}

	public void setServico(List<Servico> servico) {
		this.servico = servico;
	}

	public void setItens(Set<ItemVenda> itens) {
		this.itens = itens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Venda other = (Venda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
