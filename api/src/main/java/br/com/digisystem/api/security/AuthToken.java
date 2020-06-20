package br.com.digisystem.api.security;

import java.util.List;
import java.util.Set;

import br.com.digisystem.api.model.Cliente;
import br.com.digisystem.api.model.Endereco;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class AuthToken {
	private String token;
}
