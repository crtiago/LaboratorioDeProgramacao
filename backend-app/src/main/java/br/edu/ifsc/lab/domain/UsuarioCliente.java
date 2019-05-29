package br.edu.ifsc.lab.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_usuario")
public class UsuarioCliente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	// List<Venda> historicoVendas = new ArrayList<>();

	public UsuarioCliente() {
		super();
	}

	public UsuarioCliente(Integer id, String email, String nome, String cpf) {
		super(id, email, nome, cpf);
		// TODO Auto-generated constructor stub
	}

}
