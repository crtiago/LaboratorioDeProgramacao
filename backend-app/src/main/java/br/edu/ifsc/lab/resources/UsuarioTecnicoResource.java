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

import br.edu.ifsc.lab.domain.UsuarioTecnico;
import br.edu.ifsc.lab.dto.UsuarioTecnicoDTO;
import br.edu.ifsc.lab.services.UsuarioTecnicoService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/tecnicos")
public class UsuarioTecnicoResource {

	@Autowired
	private UsuarioTecnicoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioTecnico> find(@PathVariable Integer id) throws ObjectNotFoundException {
		UsuarioTecnico obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioTecnicoDTO objDto, @PathVariable Integer id)
			throws ObjectNotFoundException {
		UsuarioTecnico obj = service.fromDTO(objDto);
		obj.setId_usuario(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioTecnicoDTO>> findAll() {
		List<UsuarioTecnico> list = service.findAll();
		List<UsuarioTecnicoDTO> listDTO = list.stream().map(obj -> new UsuarioTecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
