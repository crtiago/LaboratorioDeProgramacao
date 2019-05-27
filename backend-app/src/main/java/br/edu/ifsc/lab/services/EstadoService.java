package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Estado;
import br.edu.ifsc.lab.repository.EstadoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository rep;

	public Estado find(Integer id) throws ObjectNotFoundException {
		Optional<Estado> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}
}
