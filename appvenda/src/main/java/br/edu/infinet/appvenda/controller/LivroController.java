package br.edu.infinet.appvenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.domain.Livro;
import br.edu.infinet.appvenda.model.domain.Produto;
import br.edu.infinet.appvenda.model.service.LivroService;
import br.edu.infinet.appvenda.model.service.ProdutoService;

@Controller
public class LivroController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private LivroService livroService;
	
	
	@GetMapping(value = "/livro/pesquisar")
	public String Pesquisar(Model model, String campoBusca) {
		List<Livro> produtoLista = livroService.pesquisar(campoBusca);
				
		if(!produtoLista.isEmpty()) {
			carregaDadosGrid(model);
			model.addAttribute("listagem", produtoLista);
			model.addAttribute("homeFeedbackPesquisaSucess", "Livro localizado...");	
			return appController.showHome(model);			
		}
		
		model.addAttribute("homeFeedbackPesquisaFail", String.format("Livro com nome %s não foi localizado...", campoBusca));	
		return obterListaLivro(model);
	}
	
	private void carregaDadosGrid(Model model) {
		model.addAttribute("rota", "livro");
		model.addAttribute("titulo", "Livro");		
	}

	@GetMapping(value = "/livro/{id}/excluir")
	public String Excluir(@PathVariable Integer id, Model model) {
		
		livroService.Excluir(id);
		
		return "redirect:/livro/lista";
	}
	
	@GetMapping(value = "/livro/lista")
	public String obterListaLivro(Model model) {

		carregaDadosGrid(model);
		model.addAttribute("listagem", livroService.ObterLista());
		model.addAttribute("searchFilter", "nome");	

		return appController.showHome(model);
	}
}
