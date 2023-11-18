package br.edu.infinet.appvenda.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.clients.IVendaClient;

@Service
public class VendaService {

	@Autowired
	private IVendaClient vendaClient;
	
	public List<String> obterInformacoes(){
		return vendaClient.obterInformacoes();
	}
	
}
