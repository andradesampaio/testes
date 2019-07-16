package br.org.springboot.testes.contato;

public class ContatoException extends Exception {

	public ContatoException(Exception e) throws ContatoException {
		super(e);
	}

}
