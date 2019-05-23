package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Pagamento;
import br.edu.ifsc.lab.repository.PagamentoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PagamentoService {

	/*
	 * Declarar uma dependencia de um objeto do tipo PagamentoRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private PagamentoRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Pagamento find(Integer id) throws ObjectNotFoundException {
		Optional<Pagamento> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
	}
}
