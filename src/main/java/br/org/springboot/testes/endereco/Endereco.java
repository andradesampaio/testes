package br.org.springboot.testes.endereco;

import lombok.Data;

@Data
public class Endereco {

	private String rua;

	public Endereco(String rua) {
		this.rua = rua;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

}
