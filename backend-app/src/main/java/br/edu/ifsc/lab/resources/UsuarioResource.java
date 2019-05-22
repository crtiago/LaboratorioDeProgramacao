package br.edu.ifsc.lab.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.lab.domain.Usuario;
import br.edu.ifsc.lab.services.UsuarioService;
import javassist.tools.rmi.ObjectNotFoundException;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource{

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	/*
	 * Para que o Spring saiba que o id da URL->value="/(id)" tem que ir pro id da
	 * variável -> Integer id tem que incluir a anotação @PathVariable
	 * 
	 * ResponseEntity é um tipo especial do Spring que já encapsula/armazena várias
	 * informações de uma resposta http para o serviço REST,coloca uma interrogação
	 * no tipo para dizer que pode ser qualquer tipo
	 */
	public ResponseEntity<Usuario> find(@PathVariable Integer id) throws ObjectNotFoundException {
		Usuario obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
