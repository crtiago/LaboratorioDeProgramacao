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
		UsuarioCliente newObj = find(obj.getId());
		updateData(newObj, obj);
		return rep.save(newObj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<UsuarioCliente> findAll() {
		return rep.findAll();
	}

	public UsuarioCliente fromDTO(UsuarioClienteDTO objDto) {
		return new UsuarioCliente(objDto.getId(), objDto.getNome(), objDto.getSenha(), objDto.getEmail(), null);
	}

	private void updateData(UsuarioCliente newObj, UsuarioCliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
