package br.edu.ifsc.lab.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Estado;
import br.edu.ifsc.lab.repository.EstadoRepository;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository rep;

	public List<Estado> findAll() {
		return rep.findAllByOrderByNome();
	}
}
