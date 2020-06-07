package br.com.digisystem.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.services.ProdutoService;

@RestController
public class ProdutoController {
	
	//int vetorInt[] = new int[10];
	List<Produto> listaProduto = new ArrayList<Produto>();
	
	//Lista de dependencias
	@Autowired
	private ProdutoService produtoService;

	//@RequestMapping( method = RequestMethod.GET, value = "primeiro" )
	@GetMapping( value = "produtos" )
	public List<Produto> getAll() {
		
		return this.produtoService.findAll();
		
	}
	
	@GetMapping( value = "produtos/{id}" )
	public Produto get( @PathVariable("id") int idProduto ) {
		
		return this.produtoService.get(idProduto);
				
	}
	
	@PostMapping ( value = "produtos" )
	public Produto create( @RequestBody Produto p  ) {
	
		System.out.println( p );
		return this.produtoService.create(p);
	}
	
	//PUT ou PATCH
	@PutMapping ( value = "produtos/{id}" )
	public Produto update( @PathVariable("id") int id, @RequestBody Produto p ) {
		//obj antigo
		Produto old = listaProduto.get(id);
		//atualizar objeto antigo
		old.setNome( p.getNome() );
		old.setPreco( p.getPreco() );
		//atualizar lista
		listaProduto.set(id, old);
		//retorna novo obj
		return old;
		
	}
	
	@DeleteMapping ( value = "produtos/{id}" )
	public void delete( @PathVariable("id") int id ) {
		
		System.out.println( id );
		
		//this.produtoService.
	
	}
	
}
