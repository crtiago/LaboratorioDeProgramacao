package br.edu.ifsc.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsc.lab.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

}
