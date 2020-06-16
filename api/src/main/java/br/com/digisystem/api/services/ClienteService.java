package br.com.digisystem.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.repositories.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public List<Cliente> findAll() {
		return this.clienteRepository.findAll();
	}
	
	public Optional<Cliente> findById(int id) {
		return this.clienteRepository.findById(id);
		// retorno cliente sem optional 
		//return this.clienteRepository.findById(id).get();
	}
	
	public Cliente create(Cliente p) {
		return this.clienteRepository.save(p);
	}

	public boolean deleteById(int id) {
		
	 this.clienteRepository.deleteById(id);
	 return true ;
	 
	}
	
//	public Cliente update(int id, Cliente prod) {
//		Optional<Cliente> search = this.clienteRepository.findById(id);
//		
//		if ( search.isPresent() ) {
//			Cliente p = search.get();
//			p.setNome( prod.getNome()  );
//			p.setPreco( prod.getPreco() );
//			
//			return this.clienteRepository.save( p );
//		}			
//		
//		return null;
//	}
	
	public Cliente get(int id) {
		return this.clienteRepository.getOne(id);
	}
	
//	public List<Cliente> findByNome( String nome, double preco ) {
//		return this.clienteRepository.findByNomeLikeAndPrecoGreaterThan(nome,preco);
//	}
	
	
}
