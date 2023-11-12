package br.edu.infinet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/produto/{id}/excluir")
	public String Excluir(@PathVariable Integer id, Model model) {
		
		produtoService.Excluir(id);
		
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		
		return "redirect:/produto/lista";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("rota", "produto");
		model.addAttribute("titulo", "Produto");
		model.addAttribute("listagem", produtoService.ObterLista());		
		
		return appController.showHome(model);
	}
}
