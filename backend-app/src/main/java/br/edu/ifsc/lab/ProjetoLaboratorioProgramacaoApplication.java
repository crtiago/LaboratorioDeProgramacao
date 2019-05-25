package br.edu.ifsc.lab;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.lab.domain.Categoria;
import br.edu.ifsc.lab.domain.Cidade;
import br.edu.ifsc.lab.domain.Cliente;
import br.edu.ifsc.lab.domain.Estado;
import br.edu.ifsc.lab.domain.ProdutoVenda;
import br.edu.ifsc.lab.domain.Tecnico;
import br.edu.ifsc.lab.domain.Usuario;
import br.edu.ifsc.lab.repository.CategoriaRepository;
import br.edu.ifsc.lab.repository.CidadeRepository;
import br.edu.ifsc.lab.repository.EstadoRepository;
import br.edu.ifsc.lab.repository.ProdutoRepository;
import br.edu.ifsc.lab.repository.UsuarioRepository;

@SpringBootApplication
public class ProjetoLaboratorioProgramacaoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private UsuarioRepository usuariorepository;
	@Autowired
	private EstadoRepository estadorepository;
	@Autowired
	private CidadeRepository cidaderepository;
	@Autowired
	private ProdutoRepository produtorepository;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoLaboratorioProgramacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");

		categoriarepository.saveAll(Arrays.asList(cat1, cat2));

		Usuario cli1 = new Cliente(null, "Cesar", "teste1", "Cesar A", "453534535353");
		Usuario cli2 = new Cliente(null, "Carlos", "teste2", "Carlos B", "34234324242424");

		Usuario tec1 = new Tecnico(null, "Carol", "7465783465", "Carol L", "473647864726", (float) 2.000);
		Usuario tec2 = new Tecnico(null, "Osmar", "567834756374", "Osmar H", "457485757", (float) 3.000);

		usuariorepository.saveAll(Arrays.asList(cli1, cli2, tec1, tec2));

		Estado est1 = new Estado(null, "Santa Catarina");
		Estado est2 = new Estado(null, "Rio Grande do Sul");

		Cidade c1 = new Cidade(null, "Lages", est1);
		Cidade c2 = new Cidade(null, "Gramado", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2));

		estadorepository.saveAll(Arrays.asList(est1, est2));
		cidaderepository.saveAll(Arrays.asList(c1, c2));

		ProdutoVenda p1 = new ProdutoVenda(null, "Z", "T", (double) 2000, "T", 10);

		produtorepository.saveAll(Arrays.asList(p1));

	}

}
