package br.edu.ifsc.lab;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.lab.domain.Categoria;
import br.edu.ifsc.lab.domain.Cidade;
import br.edu.ifsc.lab.domain.Estado;
import br.edu.ifsc.lab.domain.ProdutoCliente;
import br.edu.ifsc.lab.domain.ProdutoVenda;
import br.edu.ifsc.lab.domain.Usuario;
import br.edu.ifsc.lab.domain.UsuarioCliente;
import br.edu.ifsc.lab.domain.UsuarioTecnico;
import br.edu.ifsc.lab.domain.UsuarioVendedor;
import br.edu.ifsc.lab.repository.CategoriaRepository;
import br.edu.ifsc.lab.repository.CidadeRepository;
import br.edu.ifsc.lab.repository.EstadoRepository;
import br.edu.ifsc.lab.repository.ProdutoRepository;
import br.edu.ifsc.lab.repository.UsuarioRepository;

@SpringBootApplication
public class ProjetoLaboratorioProgramacaoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoLaboratorioProgramacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		Usuario cli1 = new UsuarioCliente(null, "Cesar", "teste1", "Cesar A", "453534535353");
		Usuario cli2 = new UsuarioCliente(null, "Carlos", "teste2", "Carlos B", "34234324242424");

		Usuario tec1 = new UsuarioTecnico(null, "Carol", "7465783465", "Carol L", "473647864726", (float) 2.000);
		Usuario tec2 = new UsuarioTecnico(null, "Osmar", "567834756374", "Osmar H", "457485757", (float) 3.000);

		Usuario vend1 = new UsuarioVendedor(null, "Isabely", "hsgdfdg", "Isabely C R", "099876788388", (float) 2.000);

		usuarioRepository.saveAll(Arrays.asList(cli1, cli2, tec1, tec2, vend1));

		Estado est1 = new Estado(null, "Santa Catarina");
		Estado est2 = new Estado(null, "Rio Grande do Sul");

		Cidade c1 = new Cidade(null, "Lages", est1);
		Cidade c2 = new Cidade(null, "Gramado", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2));

		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Date data = formato.parse("23/11/2015");

		ProdutoVenda p1 = new ProdutoVenda(null, "J", "T", 2000.00, "TTT", 10, cat1);
		ProdutoCliente p2 = new ProdutoCliente(null, "Motorola", "Moto E", "Microfone", data, data);

		cat1.getProdutos().addAll(Arrays.asList(p1));
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));

		produtoRepository.saveAll(Arrays.asList(p1, p2));

	}

}
