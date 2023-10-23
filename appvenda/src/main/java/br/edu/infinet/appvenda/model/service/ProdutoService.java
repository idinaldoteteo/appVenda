package br.edu.infinet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Produto;
import br.edu.infinet.appvenda.model.domain.Vendedor;

@Service
public class ProdutoService {

	private Map<Integer, Produto> produtoMap = new HashMap<Integer, Produto>();
	
	public Collection<Produto> ObterLista() {
		return produtoMap.values();
	}

	public void incluir(Produto produto) {
		produtoMap.put(produto.getCodigo(), produto);
	}
}
