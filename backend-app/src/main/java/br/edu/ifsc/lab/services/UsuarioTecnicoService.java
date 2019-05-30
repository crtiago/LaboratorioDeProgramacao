package br.edu.ifsc.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.UsuarioTecnico;
import br.edu.ifsc.lab.dto.UsuarioTecnicoDTO;
import br.edu.ifsc.lab.repository.UsuarioTecnicoRepository;
import br.edu.ifsc.lab.services.exceptions.DataIntegrityException;
import br.edu.ifsc.lab.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioTecnicoService {

	@Autowired
	private UsuarioTecnicoRepository rep;

	public UsuarioTecnico find(Integer id) {
		Optional<UsuarioTecnico> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + UsuarioTecnico.class.getName()));
	}

	public UsuarioTecnico update(UsuarioTecnico obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public UsuarioTecnico fromDTO(UsuarioTecnicoDTO objDto) {
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

	public List<UsuarioTecnico> findAll() {
		return rep.findAll();
	}

}
