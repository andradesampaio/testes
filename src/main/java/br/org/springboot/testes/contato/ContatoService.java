package br.org.springboot.testes.contato;

import java.util.Optional;
import java.util.stream.Stream;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContatoService {
	
	ContatoRepository contatoRepository;
	
	@Autowired
	public void ContatoRepository (ContatoRepository contatoRepository) {
		this.contatoRepository = contatoRepository;
	}

	public void inserir(Contato contato) throws ContatoException {
		try {
			contatoRepository.save(contato);
		} catch (ConstraintViolationException e) {
			throw new ContatoException(e);
		}
		
	}
	
	public void remover(Long id) {
		contatoRepository.deleteById(id);		
	};
	
	public Stream<Contato> buscarContatos(){
		return contatoRepository.buscaTodosContatos();
	}
	
	public Optional<Contato> buscarContato(Long id) {
		return contatoRepository.findById(id);
		
	}

}
