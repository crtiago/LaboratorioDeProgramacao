package br.edu.ifsc.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.UsuarioVendedor;
import br.edu.ifsc.lab.dto.UsuarioVendedorDTO;
import br.edu.ifsc.lab.repository.UsuarioVendedorRepository;
import br.edu.ifsc.lab.services.exceptions.DataIntegrityException;
import br.edu.ifsc.lab.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioVendedorService {

	@Autowired
	private UsuarioVendedorRepository rep;

	public UsuarioVendedor find(Integer id) {
		Optional<UsuarioVendedor> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + UsuarioVendedor.class.getName()));
	}

	public UsuarioVendedor update(UsuarioVendedor obj) {
		find(obj.getId());
		return rep.save(obj);
	}

	public UsuarioVendedor fromDTO(UsuarioVendedorDTO objDto) {
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

	public List<UsuarioVendedor> findAll() {
		return rep.findAll();
	}

}
