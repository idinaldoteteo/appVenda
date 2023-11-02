package br.edu.infinet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Livro;
import br.edu.infinet.appvenda.model.repository.ILivroRepository;

@Service
public class LivroService {

	@Autowired	
	private ILivroRepository livroRepository;	
	
	public Collection<Livro> ObterLista() {
		return (Collection<Livro>) livroRepository.findAll();
	}

	public void incluir(Livro livro) {
		livroRepository.save(livro);
	}
	
	public long obterQtde() {
		return livroRepository.count();
	}
}
