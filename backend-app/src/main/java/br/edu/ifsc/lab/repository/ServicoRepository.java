package br.edu.ifsc.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsc.lab.domain.Servico;


@Repository
public interface ServicoRepository extends JpaRepository<Servico, Integer> {

}
