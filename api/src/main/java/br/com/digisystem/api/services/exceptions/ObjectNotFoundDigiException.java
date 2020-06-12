package br.com.digisystem.api.services.exceptions;

public class ObjectNotFoundDigiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoundDigiException (String mensagem) {
		super(mensagem);
	}
	public ObjectNotFoundDigiException ( String mensagem , Throwable causa) {
		super (mensagem, causa);
	}
}
