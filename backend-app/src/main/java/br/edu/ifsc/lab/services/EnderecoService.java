package br.edu.ifsc.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Endereco;
import br.edu.ifsc.lab.repository.EnderecoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository rep;

	public Endereco find(Integer id) throws ObjectNotFoundException {
		Optional<Endereco> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Endereco.class.getName()));
	}

	public List<Endereco> findByUsuario(Integer usuarioId) {
		return rep.findEndereco(usuarioId);
	}
}
