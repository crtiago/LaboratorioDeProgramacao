package br.edu.ifsc.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsc.lab.domain.Orcamento;

@Repository
public interface OrcamentoRepository extends JpaRepository<Orcamento, Integer> {

}
