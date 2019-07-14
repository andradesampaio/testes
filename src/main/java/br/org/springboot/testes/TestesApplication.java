package br.org.springboot.testes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class TestesApplication {

	public static void main(String[] args) {
		
		log.info("Iniciando a aplicação");
		SpringApplication.run(TestesApplication.class, args);
	}

}
