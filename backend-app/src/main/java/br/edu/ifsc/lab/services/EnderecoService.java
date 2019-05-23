package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Endereco;
import br.edu.ifsc.lab.repository.EnderecoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EnderecoService {

	/*
	 * Declarar uma dependencia de um objeto do tipo EnderecoRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private EnderecoRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Endereco find(Integer id) throws ObjectNotFoundException {
		Optional<Endereco> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}
}
