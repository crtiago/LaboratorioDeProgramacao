package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Cidade;
import br.edu.ifsc.lab.repository.CidadeRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository rep;

	public Cidade find(Integer id) throws ObjectNotFoundException {
		Optional<Cidade> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Cidade.class.getName()));
	}
}
