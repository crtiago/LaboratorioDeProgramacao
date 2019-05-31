package br.edu.ifsc.lab.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.lab.domain.ProdutoVenda;
import br.edu.ifsc.lab.dto.ProdutoVendaDTO;
import br.edu.ifsc.lab.services.ProdutoVendaService;

@RestController
@RequestMapping(value = "/produtosvenda")
public class ProdutoVendaResource {

	@Autowired
	private ProdutoVendaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoVenda> find(@PathVariable Integer id) {
		ProdutoVenda obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ProdutoVendaDTO>> findAll() {
		List<ProdutoVenda> list = service.findAll();
		List<ProdutoVendaDTO> listDTO = list.stream().map(obj -> new ProdutoVendaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

}
