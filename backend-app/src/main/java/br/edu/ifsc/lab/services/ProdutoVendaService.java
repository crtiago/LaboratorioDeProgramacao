package br.edu.ifsc.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Categoria;
import br.edu.ifsc.lab.domain.ProdutoVenda;
import br.edu.ifsc.lab.repository.ProdutoVendaRepository;
import br.edu.ifsc.lab.services.exceptions.ObjectNotFoundException;

@Service
public class ProdutoVendaService {

	@Autowired
	private ProdutoVendaRepository rep;

	public ProdutoVenda find(Integer id) {
		Optional<ProdutoVenda> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	public List<ProdutoVenda> findAll() {
		return rep.findAll();
	}
}
