package br.edu.infinet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.appvenda.model.domain.Informacao;
import br.edu.infinet.appvenda.model.service.InformacaoService;

@Controller
public class InformacaoController {
	
	@Autowired
	private InformacaoService informacaoService;
	
	@PostMapping(value = "/informacao/incluir")
	public String incluir(Informacao informacao) {
		
		informacaoService.incluir(informacao);
		
		return "redirect:/";
	}
	
	@GetMapping(value = "/informacao/excluir/{id}")
	public String excluir(@PathVariable Integer id) {
		
		informacaoService.excluir(id);
		
		return "redirect:/";
	}
}

