package br.com.digisystem.api.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.digisystem.api.model.Produto;

@RestController
public class ProdutoController {
		
	List<Produto> listaProduto = new ArrayList<Produto>();
	
	//@RequestMapping(method = RequestMethod.GET, value="produtos" )
	@GetMapping(value="produtos")
	public List<Produto> getAll() {
		//return " Hello World  !!! ";
		
		Produto meuProduto = new Produto();	
		meuProduto.setId(1);
		meuProduto.setNome("produto 1");
		meuProduto.setPreco(100);
		
		listaProduto.add(meuProduto);

		Produto p2 = Produto
				.builder()
				.id(2)
				.nome("Produto 2")
				.preco(200)
				.build();
		

		listaProduto.add(p2);

		return listaProduto;
			
	}
	@GetMapping(value="produtos/{id}")
	public Produto  get(@PathVariable("id") int idProduto) {
		//System.out.println(idProduto);
		
		return listaProduto.get(idProduto);
		
	}
	
	@PostMapping(value="produtos")
	public Produto  create(@RequestBody Produto p) {
		System.out.println(p.getId());
		listaProduto.add(p);

		return p;
	}
}
