package br.edu.ifsc.lab.services;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.ifsc.lab.domain.Cidade;
import br.edu.ifsc.lab.domain.Endereco;
import br.edu.ifsc.lab.domain.ItemVenda;
import br.edu.ifsc.lab.domain.ProdutoVenda;
import br.edu.ifsc.lab.domain.UsuarioCliente;
import br.edu.ifsc.lab.domain.Venda;
import br.edu.ifsc.lab.dto.EnderecoDTO;
import br.edu.ifsc.lab.dto.UsuarioClienteDTO;
import br.edu.ifsc.lab.dto.VendaDTO;
import br.edu.ifsc.lab.repository.CidadeRepository;
import br.edu.ifsc.lab.repository.EnderecoRepository;
import br.edu.ifsc.lab.repository.ItemVendaRepository;
import br.edu.ifsc.lab.repository.ProdutoVendaRepository;
import br.edu.ifsc.lab.repository.UsuarioClienteRepository;
import br.edu.ifsc.lab.repository.VendaRepository;
import br.edu.ifsc.lab.services.exceptions.DataIntegrityException;
import br.edu.ifsc.lab.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioClienteService {

	@Autowired
	private UsuarioClienteRepository rep;

	@Autowired
	private EnderecoRepository repEnd;

	@Autowired
	private CidadeRepository cidRep;

	@Autowired
	private VendaRepository vendaRep;

	@Autowired
	private ProdutoVendaRepository prodVenda;

	@Autowired
	private ItemVendaRepository iv;

	public UsuarioCliente find(Integer id) {
		Optional<UsuarioCliente> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Id: " + id + ", Tipo: " + UsuarioCliente.class.getName()));
	}

	public UsuarioCliente findUserEmail(String email) {
		Optional<UsuarioCliente> obj = rep.findCliente(email);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"" + "Objeto não encontrado! Email: " + email + ", Tipo: " + UsuarioCliente.class.getName()));
	}

	public UsuarioCliente update(UsuarioCliente obj) {
		UsuarioCliente newObj = find(obj.getId_usuario());
		updateData(newObj, obj);
		return rep.save(newObj);
	}

	public UsuarioCliente insert(UsuarioCliente obj) {
		obj.setId_usuario(null);
		return rep.save(obj);
	}

	public Endereco insert(Endereco obj) {
		obj.setId(null);
		return repEnd.save(obj);
	}

	public Venda insert(Venda obj) {
		obj.setId(null);
		return vendaRep.save(obj);
	}

	public void delete(Integer id) {
		find(id);
		try {
			rep.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir porque há pedidos relacionados");
		}
	}

	public List<UsuarioCliente> findAll() {
		return rep.findAll();
	}

	public UsuarioCliente fromDTO(UsuarioClienteDTO objDto) {
		return new UsuarioCliente(objDto.getId(), objDto.getEmail(), objDto.getSenha(), objDto.getNome(),
				objDto.getCpf());
	}

	public Endereco fromDTO(EnderecoDTO objDto, UsuarioCliente cli) {

		Optional<Cidade> cidadeOp = cidRep.findById(objDto.getCidadeId());

		Cidade cidade = new Cidade(cidadeOp.get().getId(), cidadeOp.get().getNome(), cidadeOp.get().getEstado());
		Endereco end = new Endereco(null, objDto.getRua(), objDto.getCep(), objDto.getNumero(), objDto.getBairro(), cli,
				cidade);

		cli.getEnderecos().add(end);
		rep.save(cli);
		cidRep.save(cidade);

		return end;

	}

	public Venda fromDTO(VendaDTO objDto, UsuarioCliente cli) {

		Venda venda = new Venda(null, cli, objDto.getDataVenda());

		venda.getItens().addAll(objDto.getItens());
		venda.getServico().addAll(objDto.getServico());

		cli.getVendas().add(venda);
		

		for (ItemVenda iv : objDto.getItens()) {
			Optional<ProdutoVenda> produto = prodVenda.findById((iv.getProdutoVenda().getIdProduto()));
			iv.setPreco(produto.get().getValor());
			iv.setVenda(venda);
		}



		iv.saveAll(objDto.getItens());
		rep.save(cli);
		return venda;
	}

	private void updateData(UsuarioCliente newObj, UsuarioCliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}
