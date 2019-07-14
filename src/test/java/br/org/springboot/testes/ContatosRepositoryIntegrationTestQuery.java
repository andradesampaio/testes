package br.org.springboot.testes;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.org.springboot.testes.contato.Contato;
import br.org.springboot.testes.contato.ContatoRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContatosRepositoryIntegrationTestQuery {
	
	@Autowired
	private ContatoRepository contatoRepository;	

	@Before
	public void start() {
		Contato contato = Contato.builder().nome("Chefe").ddd("12").telefone("9xxxxxxx9").build();		
		contatoRepository.save(contato);
		Contato contato1 = Contato.builder().nome("Thais").ddd("11").telefone("9xxxxxxx9").build();	
		contatoRepository.save(contato1);
		Contato contato2 = Contato.builder().nome("Irmao").ddd("13").telefone("9xxxxxxx9").build();		
		contatoRepository.save(contato2);
		Contato contato3 = Contato.builder().nome("Pai").ddd("14").telefone("9xxxxxxx9").build();		
		contatoRepository.save(contato3);
		Contato contato4 = Contato.builder().nome("Mae").ddd("14").telefone("9xxxxxxx9").build();		
		contatoRepository.save(contato4);
	}
	
	@After
	public void end() {
		contatoRepository.deleteAll();
	}
	
	@Test
	public void findByNomeRetornaContato() {
		Contato contato = contatoRepository.findFirstByNome("Irmao");
		Assert.assertTrue(contato.getNome().equals("Irmao"));
	}

}
