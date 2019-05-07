package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Venda;
import br.edu.ifsc.lab.repository.VendaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class VendaService {

	/*
	 * Declarar uma dependencia de um objeto do tipo VendaRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private VendaRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Venda buscar(Integer id) throws ObjectNotFoundException {
		Optional<Venda> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
	}
}
