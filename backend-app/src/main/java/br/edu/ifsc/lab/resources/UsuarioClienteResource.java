package br.edu.ifsc.lab.resources;

import java.net.URI;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.edu.ifsc.lab.domain.Endereco;
import br.edu.ifsc.lab.domain.UsuarioCliente;
import br.edu.ifsc.lab.domain.Venda;
import br.edu.ifsc.lab.dto.UsuarioClienteDTO;
import br.edu.ifsc.lab.dto.VendaDTO;
import br.edu.ifsc.lab.services.EnderecoService;
import br.edu.ifsc.lab.services.UsuarioClienteService;
import br.edu.ifsc.lab.services.VendaService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/clientes")
public class UsuarioClienteResource {

	@Autowired
	private UsuarioClienteService service;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private VendaService vendaService;

	@CrossOrigin
	@RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioClienteDTO> find(@PathVariable Integer id) throws ObjectNotFoundException {
		UsuarioCliente obj = service.find(id);
		UsuarioClienteDTO objDTO = new UsuarioClienteDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

	@CrossOrigin
	@RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
	public ResponseEntity<UsuarioClienteDTO> findUserEmail(@PathVariable String email) throws ObjectNotFoundException {
		UsuarioCliente obj = service.findUserEmail(email);
		UsuarioClienteDTO objDTO = new UsuarioClienteDTO(obj);
		return ResponseEntity.ok().body(objDTO);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioClienteDTO objDto) {
		UsuarioCliente obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId_usuario())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{usuarioId}/enderecos", method = RequestMethod.GET)
	public ResponseEntity<List<Endereco>> findEnderecos(@PathVariable Integer usuarioId) {
		List<Endereco> list = enderecoService.findByUsuario(usuarioId);
		return ResponseEntity.ok().body(list);
	}

	@CrossOrigin
	@RequestMapping(value = "/{usuarioId}/compras", method = RequestMethod.GET)
	public ResponseEntity<List<VendaDTO>> findVenda(@PathVariable Integer usuarioId) {
		List<Venda> list = vendaService.findByUsuario(usuarioId);
		List<VendaDTO> listDTO = list.stream().map(obj -> new VendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@CrossOrigin
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
