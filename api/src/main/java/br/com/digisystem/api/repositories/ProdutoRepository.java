package br.com.digisystem.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	// SELECT * FROM Produto WHERE nome = {search}
	public List<Produto> findByNome (String nome);
}