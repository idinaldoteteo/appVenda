package br.edu.infinet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.appvenda.model.domain.Informacao;
import br.edu.infinet.appvenda.model.service.InformacaoService;

@Controller
public class InformacaoController {
	
	@Autowired
	private InformacaoService informacaoService;
	
	@PostMapping(value = "/informacao/incluir")
	public String incluir(Informacao informacao) {
		
		Informacao result = informacaoService.incluir(informacao);
		
		return "redirect:/";
	}
}

//public List<Informacao> obterLista(){		
//	return informacaoClient.obterLista();
//}
//	
//public Informacao incluir(Informacao informacao) {	
//	return informacaoClient.incluir(informacao);
//}