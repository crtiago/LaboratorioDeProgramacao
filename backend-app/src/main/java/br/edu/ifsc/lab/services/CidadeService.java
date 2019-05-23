package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Cidade;
import br.edu.ifsc.lab.repository.CidadeRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CidadeService {

	/*
	 * Declarar uma dependencia de um objeto do tipo CidadeRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private CidadeRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Cidade find(Integer id) throws ObjectNotFoundException {
		Optional<Cidade> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
}
