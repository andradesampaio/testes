package br.org.springboot.testes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AgendaControllerIntegrationRestTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void deveMostrarTodosOsContatos() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/agenda/"));
	}
}