package br.org.springboot.testes;

import javax.validation.ConstraintViolationException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.org.springboot.testes.agenda.AgendaController;
import br.org.springboot.testes.contato.Contato;
import br.org.springboot.testes.contato.ContatoException;
import br.org.springboot.testes.contato.ContatoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class AgendaControllerIntegrationTest {

	@MockBean
	private ContatoRepository contatoRepository;

	@Autowired
	private AgendaController agendaController;

	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private String nome = "Chefe";
	private String ddd = "12";
	private String telefone = "9xxxxxxx9";

	@Test
	public void inserirRegistroComDddNuloDeveLancarException() throws ContatoException {
		expectedException.expect(ContatoException.class);
		expectedException.expectMessage("O DDD deve ser preenchido");

		Mockito.when(contatoRepository.save((Contato)Mockito.any()))
		.thenThrow(new ConstraintViolationException("O DDD deve ser preenchido",null));
		agendaController.inserirRegistro(nome, null, telefone);
	}

	@Test
	public void inserirRegistroComTelefoneNuloDeveLancarException() throws ContatoException {
		expectedException.expect(ContatoException.class);
		expectedException.expectMessage("O Telefone deve ser preenchido");

		Mockito.when(contatoRepository.save((Contato)Mockito.any()))
		.thenThrow(new ConstraintViolationException("O Telefone deve ser preenchido",null));
		agendaController.inserirRegistro(nome, ddd, null);
	}

	@Test
	public void inserirRegistroComNomeNuloDeveLancarException() throws ContatoException {
		expectedException.expect(ContatoException.class);
		expectedException.expectMessage("O Nome deve ser preenchido");

		Mockito.when(contatoRepository.save((Contato)Mockito.any()))
		.thenThrow(new ConstraintViolationException("O Nome deve ser preenchido",null));
		agendaController.inserirRegistro(null, ddd, telefone);
	}

	@Test
	public void InserirRegistroDeveSalvarContato() throws ContatoException {
		agendaController.inserirRegistro(nome, ddd, telefone);
		Mockito.verify(contatoRepository,Mockito.times(1)).save( Contato.builder().nome("nome").ddd("ddd").telefone("telefone").build());
	}

	@Test
	public void removerRegistroDeveRemoverContato() {
		agendaController.removerRegistro(1L);
		Mockito.verify(contatoRepository,Mockito.times(1)).deleteById(1L);
	}

}