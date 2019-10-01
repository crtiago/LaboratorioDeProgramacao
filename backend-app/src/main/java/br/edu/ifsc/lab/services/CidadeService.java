package br.edu.ifsc.lab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Cidade;
import br.edu.ifsc.lab.repository.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	private CidadeRepository rep;

	public List<Cidade> findByEstado(Integer estadoId) {
		return rep.findCidades(estadoId);
	}
}
