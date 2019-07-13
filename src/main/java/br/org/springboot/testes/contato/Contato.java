package br.org.springboot.testes.contato;

import br.org.springboot.testes.endereco.Endereco;
import br.org.springboot.testes.pessoa.Pessoa;

public class Contato {

	private Pessoa pessoa;
	
	private Endereco endereco;

	public Contato(Pessoa pessoa, Endereco endereco) {
		this.pessoa = pessoa;
		this.endereco = endereco;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

}