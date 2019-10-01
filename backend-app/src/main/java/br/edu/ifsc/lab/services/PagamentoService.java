package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Pagamento;
import br.edu.ifsc.lab.repository.PagamentoRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository rep;

	public Pagamento find(Integer id) throws ObjectNotFoundException {
		Optional<Pagamento> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Pagamento.class.getName()));
	}
}
