package br.com.digisystem.api.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)

@Entity
public class Cliente {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private int id;
	
	private String nome;
	private String email;
	private String cpf;
	
	@OneToMany( mappedBy = "cliente" )
	@JsonIgnore
	private List<Endereco> enderecos;
	
	@ElementCollection
	@CollectionTable ( name = "telefone" )
	private Set<String> telefone = new HashSet<String>();
	
}
