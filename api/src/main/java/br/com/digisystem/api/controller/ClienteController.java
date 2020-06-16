package br.com.digisystem.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.services.ClienteService;
import br.com.digisystem.api.services.exceptions.ObjectNotFoundDigiException;

@RestController
public class ClienteController {
	
	
	//int vetorInt[] = new int[10];
		List<Cliente> listaCliente = new ArrayList<Cliente>();
		
		//Lista de dependencias
		@Autowired
		private ClienteService clienteService;

		//@RequestMapping( method = RequestMethod.GET, value = "primeiro" )
		@GetMapping( value = "clientes" )
		public ResponseEntity < List<Cliente> > getAll() {
			
			List<Cliente> list = this.clienteService.findAll();
			
			return ResponseEntity.ok().body( list );
		}
		
		@GetMapping( value = "clientes/{id}" )
		public ResponseEntity <Cliente> get( @PathVariable("id") int idCliente ) {
			
			//return this.clienteService.findById(idCliente).orElse( new Cliente(1000,"NOME", 1000) );
			
			Cliente p = this.clienteService.findById(idCliente)
					.orElseThrow( 
							() -> new ObjectNotFoundDigiException("ID do cliente não encontrado!") 
					);
			return ResponseEntity.status( HttpStatus.OK ).body( p );	
		}

		@PostMapping ( value = "clientes" )
		public Cliente create( @RequestBody Cliente p  ) {
		
			System.out.println( p );
			return this.clienteService.create(p);
		}
		
//		//PUT ou PATCH
//		@PutMapping ( value = "clientes/{id}" )
//		public Cliente update( @PathVariable("id") int id, @RequestBody Cliente p ) {
//
//			return this.clienteService.update(id, p);
//			
//			}
		
		@DeleteMapping ( value = "clientes/{id}" )
		public boolean delete( @PathVariable("id") int id ) {
			
			return this.clienteService.deleteById(id);
		}
		
//		@GetMapping( value = "clientes/search/{nome}/{preco}" )
//		public List<Cliente> getByName( @PathVariable("nome") String nome, 
//				@PathVariable("preco") double preco ,
//				@RequestParam( value = "fcid", defaultValue = "N~ao veio" ) String fcid) {
//			
//			System.out.println( fcid );
//			return this.clienteService.findByNome(nome,preco);
//					
//		}
		

		
//		@GetMapping( value = "clientes/search/{nome}" )
//		public List<Cliente> getByNameWithouPreco( 			
//				@PathVariable("nome") String nome,			
//				@RequestParam(value = "fcid", defaultValue = "") String fcid 
//			) {
//			System.out.println( fcid );
//			return this.clienteService.findByNome( nome, 0 );		
//		}

}
