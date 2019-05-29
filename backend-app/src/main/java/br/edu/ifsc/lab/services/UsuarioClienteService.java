package br.edu.ifsc.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.UsuarioCliente;
import br.edu.ifsc.lab.dto.UsuarioClienteDTO;
import br.edu.ifsc.lab.repository.UsuarioClienteRepository;
import br.edu.ifsc.lab.services.exceptions.DataIntegrityException;
import br.edu.ifsc.lab.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioClienteService {

	@Autowired
	private UsuarioClienteRepository rep;

	public UsuarioCliente find(Integer id) {
		Optional<UsuarioCliente> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + UsuarioCliente.class.getName()));
	}

	public UsuarioCliente update(UsuarioCliente obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public UsuarioCliente fromDTO(UsuarioClienteDTO objDto) {
		throw new UnsupportedOperationException();
	}

	public void delete(Integer id) {
		find(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}

	public List<UsuarioCliente> findAll() {
		return rep.findAll();
	}

}
