package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Produto;
import br.edu.ifsc.lab.repository.ProdutoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ProdutoService {

	/*
	 * Declarar uma dependencia de um objeto do tipo ProdutoRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private ProdutoRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Produto find(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
}
