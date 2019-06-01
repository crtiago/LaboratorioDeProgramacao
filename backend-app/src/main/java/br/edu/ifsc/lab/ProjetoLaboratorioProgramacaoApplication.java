package br.edu.ifsc.lab;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.lab.domain.Categoria;
import br.edu.ifsc.lab.domain.Cidade;
import br.edu.ifsc.lab.domain.Endereco;
import br.edu.ifsc.lab.domain.Estado;
import br.edu.ifsc.lab.domain.ItemVenda;
import br.edu.ifsc.lab.domain.Pagamento;
import br.edu.ifsc.lab.domain.PagamentoCartao;
import br.edu.ifsc.lab.domain.ProdutoCliente;
import br.edu.ifsc.lab.domain.ProdutoVenda;
import br.edu.ifsc.lab.domain.Servico;
import br.edu.ifsc.lab.domain.UsuarioCliente;
import br.edu.ifsc.lab.domain.UsuarioTecnico;
import br.edu.ifsc.lab.domain.UsuarioVendedor;
import br.edu.ifsc.lab.domain.Venda;
import br.edu.ifsc.lab.domain.enums.EstadoPagamento;
import br.edu.ifsc.lab.domain.enums.StatusServico;
import br.edu.ifsc.lab.repository.CategoriaRepository;
import br.edu.ifsc.lab.repository.CidadeRepository;
import br.edu.ifsc.lab.repository.EnderecoRepository;
import br.edu.ifsc.lab.repository.EstadoRepository;
import br.edu.ifsc.lab.repository.ItemVendaRepository;
import br.edu.ifsc.lab.repository.PagamentoRepository;
import br.edu.ifsc.lab.repository.ProdutoClienteRepository;
import br.edu.ifsc.lab.repository.ProdutoVendaRepository;
import br.edu.ifsc.lab.repository.ServicoRepository;
import br.edu.ifsc.lab.repository.UsuarioClienteRepository;
import br.edu.ifsc.lab.repository.UsuarioTecnicoRepository;
import br.edu.ifsc.lab.repository.UsuarioVendedorRepository;
import br.edu.ifsc.lab.repository.VendaRepository;

@SpringBootApplication
public class ProjetoLaboratorioProgramacaoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private ItemVendaRepository itemVendaRepository;
	@Autowired
	private PagamentoRepository pagamentoRepository;
	@Autowired
	private ProdutoClienteRepository produtoClienteRepository;
	@Autowired
	private ProdutoVendaRepository produtoVendaRepository;
	@Autowired
	private ServicoRepository servicoRepository;
	@Autowired
	private UsuarioClienteRepository usuarioClienteRepository;
	@Autowired
	private UsuarioTecnicoRepository usuarioTecnicoRepository;
	@Autowired
	private UsuarioVendedorRepository usuarioVendedorRepository;
	@Autowired
	private VendaRepository vendaRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoLaboratorioProgramacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Estado est1 = new Estado(null, "Santa Catarina");
		Estado est2 = new Estado(null, "Rio Grande do Sul");
		Estado est3 = new Estado(null, "Brasilia");
		Estado est4 = new Estado(null, "Mato Grosso do Sul");
		Estado est5 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Lages", est1);
		Cidade c2 = new Cidade(null, "Gramado", est2);
		Cidade c3 = new Cidade(null, " Painel", est1);

		est1.getCidades().addAll(Arrays.asList(c1, c3));
		est2.getCidades().addAll(Arrays.asList(c2));

		estadoRepository.saveAll(Arrays.asList(est1, est2, est3, est4, est5));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));

		ProdutoVenda p1 = new ProdutoVenda(null, "J", "T",(float) 1000, "TTT", 10, cat1);
		ProdutoVenda p2 = new ProdutoVenda(null, "Asus", "Z",(float) 500, "E", 20, cat1);

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		produtoVendaRepository.saveAll(Arrays.asList(p1, p2));

		UsuarioCliente cli1 = new UsuarioCliente(null, "maria@gmail.com", "Maria Silva", "09890877684");
		cli1.getTelefones().addAll(Arrays.asList("49988769006"));

		UsuarioTecnico tec1 = new UsuarioTecnico(null, "lucas@gmail.com", "Lucas Loregian", "09878964734", 3000);
		tec1.getTelefones().addAll(Arrays.asList("49987899987"));

		UsuarioVendedor vend1 = new UsuarioVendedor(null, "paola@gmail.com", "Paola Santos", "9009988998",
				(float) 2000);
		vend1.getTelefones().addAll(Arrays.asList("49998095647"));

		Endereco e1 = new Endereco(null, "Rua Flores", "88095387", 42, "Habitação", cli1, c1);
		Endereco e2 = new Endereco(null, "Rua Sergio", "99087666", 57, "Popular", tec1, c2);
		Endereco e3 = new Endereco(null, "Av Getulio", "99643309", 21, "São Paulo", vend1, c3);

		cli1.getEnderecos().addAll(Arrays.asList(e1));
		tec1.getEnderecos().addAll(Arrays.asList(e2));
		vend1.getEnderecos().addAll(Arrays.asList(e3));

		usuarioClienteRepository.saveAll(Arrays.asList(cli1));
		usuarioTecnicoRepository.saveAll(Arrays.asList(tec1));
		usuarioVendedorRepository.saveAll(Arrays.asList(vend1));
		enderecoRepository.saveAll(Arrays.asList(e1, e2, e3));

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Venda venda1 = new Venda(null, cli1, vend1, sdf.parse("30/09/2017 10:32"));

		Pagamento pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, venda1, 6);
		venda1.setPagamento(pagto1);

		cli1.getVendas().addAll(Arrays.asList(venda1));

		vendaRepository.saveAll(Arrays.asList(venda1));
		pagamentoRepository.saveAll(Arrays.asList(pagto1));

		ItemVenda iv1 = new ItemVenda(venda1, p1, 2);
		ItemVenda iv2 = new ItemVenda(venda1, p2, 1);

		venda1.getItens().addAll(Arrays.asList(iv1, iv2));

		p1.getItens().addAll(Arrays.asList(iv1));
		p2.getItens().addAll(Arrays.asList(iv2));

		itemVendaRepository.saveAll(Arrays.asList(iv1, iv2));

		ProdutoCliente prodc1 = new ProdutoCliente(null, "Asus", "Z5", "Microfone", sdf.parse("31/05/2019 10:32"), sdf.parse("05/06/2019 13:40"),
				cli1);
		Servico serv1 = new Servico(null, prodc1, "Arrumar microfone", (float) 200, StatusServico.ANALISE, tec1);

		cli1.getProdutoCliente().addAll(Arrays.asList(prodc1));
		prodc1.setServico(serv1);
		serv1.setProdutoCliente(prodc1);

		tec1.getServicos().addAll(Arrays.asList(serv1));
		serv1.setVenda(venda1);

		venda1.getServico().addAll(Arrays.asList(serv1));

		produtoClienteRepository.saveAll(Arrays.asList(prodc1));
		servicoRepository.saveAll(Arrays.asList(serv1));
	}

}
