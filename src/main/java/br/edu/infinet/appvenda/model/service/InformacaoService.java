package br.edu.infinet.appvenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.clients.IInformacaoClient;
import br.edu.infinet.appvenda.model.domain.Informacao;

@Service
public class InformacaoService {

	@Autowired
	private IInformacaoClient informacaoClient;
	
	public List<Informacao> obterLista(){		
		return informacaoClient.obterLista();
	}
		
	public Informacao incluir(Informacao informacao) {	
		return informacaoClient.incluir(informacao);
	}

	public void excluir(Integer id) {
		informacaoClient.excluir(id);
	}	
}
