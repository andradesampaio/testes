package br.org.springboot.testes.pessoa;

public class PessoaService {

	public Pessoa getPessoa(String nome) {
		return new Pessoa(nome);
	}

}
