package br.edu.ifsc.lab.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifsc.lab.domain.Endereco;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Endereco obj where obj.usuario.id = :usuarioId")
	public List<Endereco> findEndereco(@Param("usuarioId") Integer usuario_id);
}
