
package br.com.digisystem.api.handlers;

import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StandardError {

	private String mensagem;
	private int status;
	private Date timestamp;
}