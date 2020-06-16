package br.com.digisystem.api.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@EqualsAndHashCode (onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Endereco {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	@EqualsAndHashCode.Include
	private int id;
	@NotNull
	private String logradouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String bairro;
	private String cep;
	
	@ManyToOne
	@JoinColumn ( name = "cliente_id" )
	@JsonIgnore
	private Cliente cliente;
}