package br.com.digisystem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Endereco;
import br.com.digisystem.api.repositories.EnderecoRepository;

@Service
public class EnderecoService {
	

	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public List<Endereco> findAll() {
		return this.enderecoRepository.findAll();
	}
	
	public Optional<Endereco> findById(int id) {
		return this.enderecoRepository.findById(id);
		// retorno endereco sem optional 
		//return this.enderecoRepository.findById(id).get();
	}
	
	public Endereco create(Endereco p) {
		return this.enderecoRepository.save(p);
	}

	public boolean deleteById(int id) {
		
	 this.enderecoRepository.deleteById(id);
	 return true ;
	 
	}
	
//	public Endereco update(int id, Endereco prod) {
//		Optional<Endereco> search = this.enderecoRepository.findById(id);
//		
//		if ( search.isPresent() ) {
//			Endereco p = search.get();
//			p.setNome( prod.getNome()  );
//			p.setPreco( prod.getPreco() );
//			
//			return this.enderecoRepository.save( p );
//		}			
//		
//		return null;
//	}
	
	public Endereco get(int id) {
		return this.enderecoRepository.getOne(id);
	}
	
//	public List<Endereco> findByNome( String nome, double preco ) {
//		return this.enderecoRepository.findByNomeLikeAndPrecoGreaterThan(nome,preco);
//	}
//	
	

}
