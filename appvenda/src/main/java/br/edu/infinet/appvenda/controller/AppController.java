package br.edu.infinet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.edu.infinet.appvenda.model.service.LivroService;
import br.edu.infinet.appvenda.model.service.ProdutoService;
import br.edu.infinet.appvenda.model.service.VendedorService;
import br.edu.infinet.appvenda.model.service.VestuarioService;

@Controller
public class AppController {

	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private LivroService livroService;
	
	@Autowired
	private VestuarioService vestuarioService;
	
	
	@GetMapping(value = "/")
	public String showHome(Model model) {
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		model.addAttribute("qtdeProduto", produtoService.obterQtde());
		model.addAttribute("qtdeLivro", livroService.obterQtde());
		model.addAttribute("qtdeVestuario", vestuarioService.obterQtde());
		
		return "home";
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterListaVendedor(Model model) {
		
		model.addAttribute("titulo", "Vendedor");
		model.addAttribute("listagem", vendedorService.ObterLista());		
		
		return showHome(model);
	}
	
	@GetMapping(value = "/produto/lista")
	public String obterListaProduto(Model model) {
		
		model.addAttribute("titulo", "Produto");
		model.addAttribute("listagem", produtoService.ObterLista());		
		
		return showHome(model);
	}
	
	@GetMapping(value = "/livro/lista")
	public String obterListaLivro(Model model) {
		
		model.addAttribute("titulo", "Livro");
		model.addAttribute("listagem", livroService.ObterLista());		
		
		return showHome(model);
	}
	
	@GetMapping(value = "/vestuario/lista")
	public String obterListaVestuario(Model model) {
		
		model.addAttribute("titulo", "Vestuário");
		model.addAttribute("listagem", vestuarioService.ObterLista());		
		
		return showHome(model);
	}
}
