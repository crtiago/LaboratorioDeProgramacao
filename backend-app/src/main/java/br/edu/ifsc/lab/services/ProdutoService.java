package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Produto;
import br.edu.ifsc.lab.repository.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository rep;

	public Produto find(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
}
