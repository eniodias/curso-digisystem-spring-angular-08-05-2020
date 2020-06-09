package br.com.digisystem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Produto;
import br.com.digisystem.api.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public List<Produto> findAll() {
		return this.produtoRepository.findAll();
	}
	
	public Optional<Produto> findById(int id) {
		return this.produtoRepository.findById(id);
		// retorno produto sem optional 
		//return this.produtoRepository.findById(id).get();
	}
	
	public Produto create(Produto p) {
		return this.produtoRepository.save(p);
	}

	public boolean deleteById(int id) {
		
	 this.produtoRepository.deleteById(id);
	 return true ;
	 
	}
	
	public Produto update(int id, Produto prod) {
		Optional<Produto> search = this.produtoRepository.findById(id);
		
		if ( search.isPresent() ) {
			Produto p = search.get();
			p.setNome( prod.getNome()  );
			p.setPreco( prod.getPreco() );
			
			return this.produtoRepository.save( p );
		}			
		
		return null;
	}
	
	public Produto get(int id) {
		return this.produtoRepository.getOne(id);
	}
	
	public List<Produto> findByNome( String nome ) {
		return this.produtoRepository.findByNome(nome);
	}
	
	
}
