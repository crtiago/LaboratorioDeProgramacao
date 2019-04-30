package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Servico;
import br.edu.ifsc.lab.repository.ServicoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ServicoService {

	/*
	 * Declarar uma dependencia de um objeto do tipo ServicoRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private ServicoRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Servico buscar(Integer id) throws ObjectNotFoundException {
		Optional<Servico> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
	}
}
