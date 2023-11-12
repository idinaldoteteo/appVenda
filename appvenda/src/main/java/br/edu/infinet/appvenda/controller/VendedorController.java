package br.edu.infinet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.service.VendedorService;

@Controller
public class VendedorController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping(value = "/vendedor/{id}/excluir")
	public String Excluir(@PathVariable Integer id, Model model) {
		
		vendedorService.Excluir(id);
		
		model.addAttribute("qtdeVendedor", vendedorService.obterQtde());
		
		return "redirect:/vendedor/lista";
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterLista(Model model) {
		
		model.addAttribute("rota", "vendedor");
		model.addAttribute("titulo", "Vendedor");
		model.addAttribute("listagem", vendedorService.ObterLista());		
		
		return appController.showHome(model);
	}
}
