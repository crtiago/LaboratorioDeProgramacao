package br.edu.ifsc.lab;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.lab.domain.Categoria;
import br.edu.ifsc.lab.domain.Cliente;
import br.edu.ifsc.lab.domain.Usuario;
import br.edu.ifsc.lab.repository.CategoriaRepository;
import br.edu.ifsc.lab.repository.UsuarioRepository;

@SpringBootApplication
public class ProjetoLaboratorioProgramacaoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriarepository;
	@Autowired
	private UsuarioRepository usuariorepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoLaboratorioProgramacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
			
		categoriarepository.saveAll(Arrays.asList(cat1,cat2));
		
		Usuario user1 = new Cliente(null, "Cesar", "teste1", "Cesar A", "453534535353");
		Usuario user2 = new Cliente(null, "Carlos", "teste2", "Carlos B", "34234324242424");
		
		usuariorepository.saveAll(Arrays.asList(user1,user2));

	}

}
