package br.edu.infinet.appvenda.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.service.VendedorService;

@Controller
public class VendedorController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping(value = "/vendedor/pesquisar")
	public String Pesquisar(Model model, String campoBusca) {
		Vendedor vendedor = vendedorService.pesquisar(campoBusca);
		
		List<Vendedor> vendedorLista = new ArrayList<Vendedor>();
				
		if(vendedor != null) {
			vendedorLista.add(vendedor);
			carregaDadosGrid(model);
			model.addAttribute("listagem", vendedorLista);
			model.addAttribute("homeFeedbackPesquisaSucess", "Vendedor localizado...");	
			return appController.showHome(model);			
		}
		
		model.addAttribute("homeFeedbackPesquisaFail", String.format("Vendedor com cpf %s não foi localizado...", campoBusca));	
		return obterLista(model);
	}
	
	@GetMapping(value = "/vendedor/{id}/excluir")
	public String Excluir(@PathVariable Integer id) {
		
		vendedorService.Excluir(id);
		
		return "redirect:/vendedor/lista";
	}
	
	@GetMapping(value = "/vendedor/lista")
	public String obterLista(Model model) {
		
		carregaDadosGrid(model);
		model.addAttribute("listagem", vendedorService.ObterLista());
		model.addAttribute("searchFilter", "cpf");		
		
		return appController.showHome(model);
	}
	
	public void carregaDadosGrid(Model model) {
		model.addAttribute("rota", "vendedor");
		model.addAttribute("titulo", "Vendedor");
	}
}
