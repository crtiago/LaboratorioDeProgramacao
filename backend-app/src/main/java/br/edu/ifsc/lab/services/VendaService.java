package br.edu.ifsc.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Venda;
import br.edu.ifsc.lab.repository.VendaRepository;
import br.edu.ifsc.lab.services.exceptions.ObjectNotFoundException;

@Service
public class VendaService {

	@Autowired
	private VendaRepository rep;

	public Venda find(Integer id) {
		Optional<Venda> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Venda.class.getName()));
	}

	public List<Venda> findByUsuario(Integer usuarioId) {
		return rep.findVenda(usuarioId);
	}
}
