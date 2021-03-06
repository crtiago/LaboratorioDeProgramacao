package br.edu.ifsc.lab.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

/*
* Classe representando o ItemVenda e o ID da classe é linkado a classe {@link ItemVendaPK}
*/

@Entity
public class ItemVenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemVendaPK id = new ItemVendaPK();

	private Integer quantidade;
	private Float preco;

	public ItemVenda() {

	}

	public ItemVenda(Venda venda, ProdutoVenda produtoVenda, Integer quantidade) {
		super();
		id.setVenda(venda);
		id.setProdutoVenda(produtoVenda);
		this.quantidade = quantidade;
		this.preco = produtoVenda.getValor();
	}

	public float getSubTotal() {
		return (preco * quantidade);
	}

	@JsonIgnore
	public Venda getVenda() {
		return id.getVenda();
	}

	public void setVenda(Venda venda) {
		id.setVenda(venda);
	}

	public void setProdutoVenda(ProdutoVenda produto) {
		id.setProdutoVenda(produto);
	}

	public ProdutoVenda getProdutoVenda() {
		return id.getProdutoVenda();
	}

	public ItemVendaPK getId() {
		return id;
	}

	public void setId(ItemVendaPK id) {
		this.id = id;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
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
		ItemVenda other = (ItemVenda) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
