package br.edu.infinet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.service.LivroService;
import br.edu.infinet.appvenda.model.service.ProdutoService;

@Controller
public class LivroController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private LivroService livroService;
	
	@GetMapping(value = "/livro/{id}/excluir")
	public String Excluir(@PathVariable Integer id, Model model) {
		
		livroService.Excluir(id);
		
		model.addAttribute("qtdeLivro", livroService.obterQtde());
		
		return "redirect:/livro/lista";
	}
	
	@GetMapping(value = "/livro/lista")
	public String obterListaLivro(Model model) {

		model.addAttribute("rota", "livro");
		model.addAttribute("titulo", "Livro");
		model.addAttribute("listagem", livroService.ObterLista());

		return appController.showHome(model);
	}
}
