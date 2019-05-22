package br.edu.ifsc.lab.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Usuario;
import br.edu.ifsc.lab.repository.UsuarioRepository;
import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class UsuarioService {

	/*
	 * Declarar uma dependencia de um objeto do tipo UsuarioRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private UsuarioRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Usuario find(Integer id) throws ObjectNotFoundException {
		Optional<Usuario> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
}
