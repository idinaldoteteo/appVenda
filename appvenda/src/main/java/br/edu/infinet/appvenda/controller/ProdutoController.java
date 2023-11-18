package br.edu.infinet.appvenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.domain.Produto;
import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.service.ProdutoService;

@Controller
public class ProdutoController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/produto/pesquisar")
	public String Pesquisar(Model model, String campoBusca) {
		List<Produto> produtoLista = produtoService.pesquisar(campoBusca);
				
		if(!produtoLista.isEmpty()) {
			carregaDadosGrid(model);
			model.addAttribute("listagem", produtoLista);
			model.addAttribute("homeFeedbackPesquisaSucess", "Produto localizado...");	
			return appController.showHome(model);			
		}
		
		model.addAttribute("homeFeedbackPesquisaFail", String.format("Produto com código %s não foi localizado...", campoBusca));	
		return obterListaProduto(model);
	}
	
	private void carregaDadosGrid(Model model) {
		model.addAttribute("rota", "produto");
		model.addAttribute("titulo", "Produto");		
	}

	@GetMapping(value = "/produto/{id}/excluir")
	public String Excluir(@PathVariable Integer id) {
		
		produtoService.Excluir(id);
		
		return "redirect:/produto/lista";
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		carregaDadosGrid(model);
		model.addAttribute("listagem", produtoService.ObterLista());
		model.addAttribute("searchFilter", "código");	
		
		return appController.showHome(model);
	}
}
