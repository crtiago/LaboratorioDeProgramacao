package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Orcamento;
import br.edu.ifsc.lab.repository.OrcamentoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class OrcamentoService {

	/*
	 * Declarar uma dependencia de um objeto do tipo OrcamentoRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private OrcamentoRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Orcamento find(Integer id) throws ObjectNotFoundException {
		Optional<Orcamento> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Orcamento.class.getName()));
	}
}
