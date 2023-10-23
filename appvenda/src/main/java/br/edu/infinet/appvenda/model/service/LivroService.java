package br.edu.infinet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Livro;

@Service
public class LivroService {

	private Map<Integer, Livro> livroMap = new HashMap<Integer, Livro>();
	
	public Collection<Livro> ObterLista() {
		return livroMap.values();
	}

	public void incluir(Livro produto) {
		livroMap.put(produto.getCodigo(), produto);
	}
}
