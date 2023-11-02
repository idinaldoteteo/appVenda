package br.edu.infinet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Produto;
import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.repository.IProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private IProdutoRepository produtoRepository;
	
	public Collection<Produto> ObterLista() {
		return (Collection<Produto>) produtoRepository.findAll();
	}
	
	public Collection<Produto> ObterLista(Integer produtoId) {
		return (Collection<Produto>) produtoRepository.ObterLista(produtoId);
	}

	public void incluir(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void GerarRelatorioProdutosPorVendedorComId(Integer vendedorId) {
		System.out.println(String.format("\n---- Início do Relatório de produto do Vendedor %d ----",vendedorId));
		
		for (Produto produtoItem : ObterLista(vendedorId)) {
			System.out.println(produtoItem);
		}
		
		System.out.println(String.format("---- Término do Relatório de produto do Vendedor %d ----\n",vendedorId));
	}

	public void GerarRelatorioProdutos() {
		System.out.println("\n---- Início do Relatório de todos os Produtos ----");
		
		for (Produto produtoItem : ObterLista()) {
			System.out.println(produtoItem);
		}	
		
		System.out.println("---- Término do Relatório de todos os Produtos ----\n");
	}
	
	public long obterQtde() {
		return produtoRepository.count();
	}
}
