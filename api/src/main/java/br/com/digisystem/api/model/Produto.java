package br.com.digisystem.api.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)

@Entity
public class Produto {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	private int id;
	private String nome;
	private double preco;
	
	@ManyToMany
	@JoinTable (
			name = "produtos_categorias",
			joinColumns = @JoinColumn (name="product_id"),
			inverseJoinColumns = @JoinColumn(name="categoria_id")
			)
	private List<Categoria> categorias;
		
}
