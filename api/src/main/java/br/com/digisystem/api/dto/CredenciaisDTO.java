package br.com.digisystem.api.dto;

import java.util.List;
import java.util.Set;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CredenciaisDTO {

	private String email;
	private String senha;
}
