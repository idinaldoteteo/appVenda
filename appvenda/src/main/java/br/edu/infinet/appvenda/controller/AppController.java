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
	
}
