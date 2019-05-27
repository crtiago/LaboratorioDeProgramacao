package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Venda;
import br.edu.ifsc.lab.repository.VendaRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository rep;

	public Venda find(Integer id) throws ObjectNotFoundException {
		Optional<Venda> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
	}
}
