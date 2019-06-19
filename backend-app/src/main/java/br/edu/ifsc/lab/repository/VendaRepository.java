package br.edu.ifsc.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifsc.lab.domain.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Venda obj where obj.usuarioCliente.id = :usuarioId")
	public List<Venda> findVenda(@Param("usuarioId") Integer usuario_id);
}
