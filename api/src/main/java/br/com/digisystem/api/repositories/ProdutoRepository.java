package br.com.digisystem.api.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.digisystem.api.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

	// SELECT * FROM Produto WHERE nome = {search}
	public List<Produto> findByNomeContains(String nome);
	
	
	// SELECT * FROM Produto WHERE nome like {%search%} and preco > {preco} 
	@Query("select prod from Produto prod where prod.nome = :nomeProduto and prod.preco >= :precoProduto")
	public List<Produto> procurarPorProdutoePreco (
			@Param ("nomeProduto") String nome,
			@Param ("precoProduto") double preco    );
	
	//@ApiModelProperty(name = "nome", required = true)
	
//	@Query("select prod from Produto prod JOIN Categoria prod.categorias cat where prod.nome = :nomeProduto and prod.preco >= :precoProduto")
//	public List<Produto> procurarPorProdutoePreco (
//			@Param ("nomeProduto") String nome,
//			@Param ("precoProduto") double preco    );
	
	
}
