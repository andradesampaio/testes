package br.org.springboot.testes.endereco;

public class EnderecoService {

	public Endereco getEndereco(String rua) {
		return new Endereco(rua);
	}

}
