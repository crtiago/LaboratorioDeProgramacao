package br.edu.ifsc.lab.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.lab.domain.UsuarioVendedor;
import br.edu.ifsc.lab.dto.UsuarioVendedorDTO;
import br.edu.ifsc.lab.services.UsuarioVendedorService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/vendedores")
public class UsuarioVendedorResource {

	@Autowired
	private UsuarioVendedorService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioVendedor> find(@PathVariable Integer id) {
		UsuarioVendedor obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioVendedorDTO objDto, @PathVariable Integer id)
			throws ObjectNotFoundException {
		UsuarioVendedor obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioVendedorDTO>> findAll() {
		List<UsuarioVendedor> list = service.findAll();
		List<UsuarioVendedorDTO> listDTO = list.stream().map(obj -> new UsuarioVendedorDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
