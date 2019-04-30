package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.ItemVenda;
import br.edu.ifsc.lab.repository.ItemVendaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ItemVendaService {

	/*
	 * Declarar uma dependencia de um objeto do tipo ItemVendaRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private ItemVendaRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public ItemVenda buscar(Integer id) throws ObjectNotFoundException {
		Optional<ItemVenda> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + ItemVenda.class.getName()));
	}
}
