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
import org.springframework.web.bind.annotation.RequestParam;
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
		
		return this.produtoService.findById(idProduto).orElse(new Produto(1000,"NOME",1000));
				
	}
	
	@PostMapping ( value = "produtos" )
	public Produto create( @RequestBody Produto p  ) {
	
		System.out.println( p );
		return this.produtoService.create(p);
	}
	
	//PUT ou PATCH
	@PutMapping ( value = "produtos/{id}" )
	public Produto update( @PathVariable("id") int id, @RequestBody Produto p ) {

		return this.produtoService.update(id, p);
		
		}
	
	@DeleteMapping ( value = "produtos/{id}" )
	public boolean delete( @PathVariable("id") int id ) {
		
		return this.produtoService.deleteById(id);
	}
	
	@GetMapping( value = "produtos/search/{nome}/{preco}" )
	public List<Produto> getByName( @PathVariable("nome") String nome, 
			@PathVariable("preco") double preco ,
			@RequestParam( value = "fcid", defaultValue = "N~ao veio" ) String fcid) {
		
		System.out.println( fcid );
		return this.produtoService.findByNome(nome,preco);
				
	}
	

	
	@GetMapping( value = "produtos/search/{nome}" )
	public List<Produto> getByNameWithouPreco( 			
			@PathVariable("nome") String nome,			
			@RequestParam(value = "fcid", defaultValue = "") String fcid 
		) {
		System.out.println( fcid );
		return this.produtoService.findByNome( nome, 0 );		
	}
}
