package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.ItemVenda;
import br.edu.ifsc.lab.repository.ItemVendaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ItemVendaService {

	@Autowired
	private ItemVendaRepository rep;

	public ItemVenda find(Integer id) throws ObjectNotFoundException {
		Optional<ItemVenda> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + ItemVenda.class.getName()));
	}
}
