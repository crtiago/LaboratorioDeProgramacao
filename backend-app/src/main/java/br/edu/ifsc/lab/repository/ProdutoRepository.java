package br.edu.ifsc.lab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifsc.lab.domain.Produto;

/*
 * Classe capaz de acessar o BD,fazer as consultas para acessar os dados da tabela Produto
 * JpaRepository tipo especial do Spring capaz de acessar os dados com base em um tipo que você 
 * passar que no caso é Produto,e também deve colocar qual o tipo do atributo identificador desse obejto
 * que no caso é Integer
 */
@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}
