package br.edu.ifsc.lab.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.edu.ifsc.lab.domain.enums.StatusServico;

@Entity
public class Servico implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descServico;
	private Float valor;
	private Integer status;

	@MapsId
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PK_PRODUTO")
	private Produto produtoCliente;

	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private UsuarioTecnico usuarioTecnico;

	public Servico() {

	}

	public Servico(Integer id, Produto produtoCliente, String descServico, Float valor, StatusServico status,
			UsuarioTecnico usuarioTecnico) {
		super();
		this.id = id;
		this.produtoCliente = produtoCliente;
		this.descServico = descServico;
		this.valor = valor;
		this.status = status.getCod();
		this.usuarioTecnico = usuarioTecnico;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Produto getProdutoCliente() {
		return produtoCliente;
	}

	public void setProdutoCliente(Produto produtoCliente) {
		this.produtoCliente = produtoCliente;
	}

	public String getDescServico() {
		return descServico;
	}

	public void setDescServico(String descServico) {
		this.descServico = descServico;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	public StatusServico getStatus() {
		return StatusServico.toEnum(status);
	}

	public void setStatus(StatusServico status) {
		this.status = status.getCod();
	}

	public UsuarioTecnico getTecnico() {
		return usuarioTecnico;
	}

	public void setTecnico(UsuarioTecnico usuarioTecnico) {
		this.usuarioTecnico = usuarioTecnico;
	}

	public UsuarioTecnico getUsuarioTecnico() {
		return usuarioTecnico;
	}

	public void setUsuarioTecnico(UsuarioTecnico usuarioTecnico) {
		this.usuarioTecnico = usuarioTecnico;
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
		Servico other = (Servico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
