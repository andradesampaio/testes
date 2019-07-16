package br.org.springboot.testes.contato;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor @AllArgsConstructor
@Data
@Builder
@Table(name = "contato")
public class Contato {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message="O DDD deve ser preenchido")
	private String ddd;

	@NotEmpty(message="O Telefone deve ser preenchido")
	private String telefone;

	@NotEmpty(message="O Nome deve ser preenchido")
	private String nome;


}