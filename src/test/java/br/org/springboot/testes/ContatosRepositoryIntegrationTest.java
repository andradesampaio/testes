package br.org.springboot.testes;

import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.org.springboot.testes.contato.Contato;
import br.org.springboot.testes.contato.ContatoRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
//Configurar banco de dados em memória para fins de teste 
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.HSQL)
public class ContatosRepositoryIntegrationTest {

	@Autowired
	private ContatoRepository contatoRepository;

	//A ExpectedException permite que você verifique se seu código lança uma exceção específica
	@Rule
	public ExpectedException expectedException = ExpectedException.none();

	private Contato contato;

	@Before
	public void start() {
		contato = Contato.builder()
				  .nome("Chefe")
				  .ddd("12")
				  .telefone("9xxxxxxx9")
				  .build();				  
	}

	@Test
	public void saveComDddNuloDeveLancarException() throws Exception {
		
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O DDD deve ser preenchido");

		contato.setDdd(null);
		contatoRepository.save(contato);
	}

	@Test
	public void saveComTelefoneNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O Telefone deve ser preenchido");

		contato.setTelefone(null);
		contatoRepository.save(contato);
	}

	@Test
	public void saveComNomeNuloDeveLancarException() throws Exception {
		expectedException.expect(ConstraintViolationException.class);
		expectedException.expectMessage("O Nome deve ser preenchido");

		contato.setNome(null);
		contatoRepository.save(contato);
	}

	@Test
	public void saveDeveSalvarContato() {
		contatoRepository.save(contato);
		List<Contato> contatos = contatoRepository.findAll();
		Assert.assertEquals(1, contatos.size());
		contatoRepository.deleteAll();
	}

	@Test
	public void deleteByIdDeveRemoverContato() {
		contatoRepository.save(contato);
		List<Contato> contatos = contatoRepository.findAll();
		Assert.assertEquals(1, contatos.size());

		contatoRepository.deleteById(contato.getId());
		List<Contato> resultado = contatoRepository.findAll();
		Assert.assertEquals(0, resultado.size());
	}
	
	

}