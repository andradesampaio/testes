package br.org.springboot.testes.contato;

import br.org.springboot.testes.endereco.EnderecoService;
import br.org.springboot.testes.pessoa.PessoaService;

public class ContatoService {

	private PessoaService pessoaService = new PessoaService();
	private EnderecoService enderecoService = new EnderecoService();

//	public Contato criaContato(String nome, String rua) {
//		Pessoa pessoa = pessoaService.getPessoa(nome);
//		Endereco endereco = enderecoService.getEndereco(rua);
//		return new Contato(1l, pessoa, endereco);
//	}

}
