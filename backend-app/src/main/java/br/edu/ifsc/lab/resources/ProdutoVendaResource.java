package br.edu.ifsc.lab.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifsc.lab.domain.ProdutoVenda;
import br.edu.ifsc.lab.services.ProdutoVendaService;

@RestController
@RequestMapping(value = "/produtosvendas")
public class ProdutoVendaResource {

	@Autowired
	private ProdutoVendaService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ProdutoVenda> find(@PathVariable Integer id) {
		ProdutoVenda obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}

}
