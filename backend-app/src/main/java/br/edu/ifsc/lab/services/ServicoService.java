package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Servico;
import br.edu.ifsc.lab.repository.ServicoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class ServicoService {

	@Autowired
	private ServicoRepository rep;

	public Servico find(Integer id) throws ObjectNotFoundException {
		Optional<Servico> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Servico.class.getName()));
	}
}
