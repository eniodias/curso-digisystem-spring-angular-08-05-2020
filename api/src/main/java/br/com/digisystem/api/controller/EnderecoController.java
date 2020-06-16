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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.digisystem.api.model.Endereco;
import br.com.digisystem.api.services.EnderecoService;
import br.com.digisystem.api.services.exceptions.ObjectNotFoundDigiException;

public class EnderecoController {
	
	//int vetorInt[] = new int[10];
		List<Endereco> listaEndereco = new ArrayList<Endereco>();
		
		//Lista de dependencias
		@Autowired
		private EnderecoService enderecoService;

		//@RequestMapping( method = RequestMethod.GET, value = "primeiro" )
		@GetMapping( value = "enderecos" )
		public ResponseEntity < List<Endereco> > getAll() {
			
			List<Endereco> list = this.enderecoService.findAll();
			
			return ResponseEntity.ok().body( list );
		}
		
		@GetMapping( value = "enderecos/{id}" )
		public ResponseEntity <Endereco> get( @PathVariable("id") int idEndereco ) {
			
			//return this.enderecoService.findById(idEndereco).orElse( new Endereco(1000,"NOME", 1000) );
			
			Endereco p = this.enderecoService.findById(idEndereco)
					.orElseThrow( 
							() -> new ObjectNotFoundDigiException("ID do endereco não encontrado!") 
					);
			return ResponseEntity.status( HttpStatus.OK ).body( p );	
		}

		@PostMapping ( value = "enderecos" )
		public Endereco create( @RequestBody Endereco p  ) {
		
			System.out.println( p );
			return this.enderecoService.create(p);
		}
		
//		//PUT ou PATCH
//		@PutMapping ( value = "enderecos/{id}" )
//		public Endereco update( @PathVariable("id") int id, @RequestBody Endereco p ) {
//
//			return this.enderecoService.update(id, p);
//			
//			}
		
		@DeleteMapping ( value = "enderecos/{id}" )
		public boolean delete( @PathVariable("id") int id ) {
			
			return this.enderecoService.deleteById(id);
		}
		
//		@GetMapping( value = "enderecos/search/{nome}/{preco}" )
//		public List<Endereco> getByName( @PathVariable("nome") String nome, 
//				@PathVariable("preco") double preco ,
//				@RequestParam( value = "fcid", defaultValue = "N~ao veio" ) String fcid) {
//			
//			System.out.println( fcid );
//			return this.enderecoService.findByNome(nome,preco);
//					
//		}
		

		
//		@GetMapping( value = "enderecos/search/{nome}" )
//		public List<Endereco> getByNameWithouPreco( 			
//				@PathVariable("nome") String nome,			
//				@RequestParam(value = "fcid", defaultValue = "") String fcid 
//			) {
//			System.out.println( fcid );
//			return this.enderecoService.findByNome( nome, 0 );		
//		}
}
