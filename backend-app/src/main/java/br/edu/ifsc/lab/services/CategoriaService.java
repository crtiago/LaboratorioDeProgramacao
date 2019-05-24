package br.edu.ifsc.lab.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Categoria;
import br.edu.ifsc.lab.dto.CategoriaDTO;
import br.edu.ifsc.lab.repository.CategoriaRepository;
import br.edu.ifsc.lab.services.exceptions.DataIntegrityException;
import br.edu.ifsc.lab.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {

	/*
	 * Declarar uma dependencia de um objeto do tipo CategoriaRepository Para
	 * instanciar esse repositorio usa @Autowired,com isso essa dependencia vai ser
	 * automaticamente instanciada pelo Spring
	 */

	@Autowired
	private CategoriaRepository rep;

	/*
	 * Criar uma operação capaz de buscar uma categoria por código
	 */
	public Categoria find(Integer id) {
		Optional<Categoria> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}

	/*
	 * Método para inserir uma categoria utilizando o repositório
	 */

	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return rep.save(obj);
	}

	/*
	 * Método para atualizar uma categoria
	 */

	public Categoria update(Categoria obj){
		find(obj.getId());
		return rep.save(obj);
	}

	/*
	 * Método auxiliar,para que a partir de um objeto CategoriaDTO vai ser
	 * construido um objeto Categoria Intancia uma categoria a partir de um DTO
	 */
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome());
	}

	/*
	 * Método para deletar uma categoria
	 */

	public void delete(Integer id) {
		find(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui produtos");
		}
	}
	
	/*
	 * Método para buscar a lista de categorias
	 */

	public List<Categoria> findAll() {
		return rep.findAll();
	}

}
