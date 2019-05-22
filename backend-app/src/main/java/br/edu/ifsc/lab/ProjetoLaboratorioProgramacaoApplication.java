package br.edu.ifsc.lab;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.ifsc.lab.domain.Categoria;
import br.edu.ifsc.lab.repository.CategoriaRepository;

@SpringBootApplication
public class ProjetoLaboratorioProgramacaoApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriarepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ProjetoLaboratorioProgramacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriarepository.saveAll(Arrays.asList(cat1,cat2));

	}

}
