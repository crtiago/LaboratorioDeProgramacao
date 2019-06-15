package br.edu.ifsc.lab.resources;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.lab.domain.Endereco;
import br.edu.ifsc.lab.domain.UsuarioCliente;
import br.edu.ifsc.lab.dto.UsuarioClienteDTO;
import br.edu.ifsc.lab.services.EnderecoService;
import br.edu.ifsc.lab.services.UsuarioClienteService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/clientes")
public class UsuarioClienteResource {

	@Autowired
	private UsuarioClienteService service;

	@Autowired
	private EnderecoService enderecoService;

	/*
	 * @RequestMapping(value = "/{id}", method = RequestMethod.GET) >>>>>>>
	 * 296bd7ceccdd70cce9392273d86be02ec4b0f21d public
	 * ResponseEntity<UsuarioCliente> find(@PathVariable Integer id) throws
	 * ObjectNotFoundException { UsuarioCliente obj = service.find(id); return
	 * ResponseEntity.ok().body(obj); }
	 */

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioClienteDTO> find(@PathVariable Integer id) throws ObjectNotFoundException {
		UsuarioCliente obj = service.find(id);
		UsuarioClienteDTO objDTO = new UsuarioClienteDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

	@RequestMapping(value = "/{usuarioId}/enderecos", method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> findEnderecos(@PathVariable Integer usuarioId) {
		List<Endereco> list = enderecoService.findByUsuario(usuarioId);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioClienteDTO objDto, @PathVariable Integer id)
			throws ObjectNotFoundException {
		UsuarioCliente obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<UsuarioClienteDTO>> findAll() {
		List<UsuarioCliente> list = service.findAll();
		List<UsuarioClienteDTO> listDTO = list.stream().map(obj -> new UsuarioClienteDTO(obj))
				.collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
