package br.edu.ifsc.lab.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ifsc.lab.domain.UsuarioCliente;

@Repository
public interface UsuarioClienteRepository extends JpaRepository<UsuarioCliente, Integer> {

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM UsuarioCliente obj where obj.email = :email")
	public Optional<UsuarioCliente> findCliente(@Param("email") String email);

}
