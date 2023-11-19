package br.edu.infinet.appvenda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.domain.Vestuario;
import br.edu.infinet.appvenda.model.service.VestuarioService;

@Controller
public class VestuarioController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private VestuarioService vestuarioService;
	
	@GetMapping(value = "/vestuario/pesquisar")
	public String Pesquisar(Model model, String campoBusca) {
		List<Vestuario> produtoLista = vestuarioService.pesquisar(campoBusca);
				
		if(!produtoLista.isEmpty()) {
			carregaDadosGrid(model);
			model.addAttribute("listagem", produtoLista);
			model.addAttribute("homeFeedbackPesquisaSucess", "Livro localizado...");	
			return appController.showHome(model);			
		}
		
		model.addAttribute("homeFeedbackPesquisaFail", String.format("Vestuário com marca %s não foi localizado...", campoBusca));	
		return obterListaVestuario(model);
	}
	
	private void carregaDadosGrid(Model model) {
		model.addAttribute("rota", "vestuario");
		model.addAttribute("titulo", "Vestuário");		
	}

	@GetMapping(value = "/vestuario/{id}/excluir")
	public String Excluir(@PathVariable Integer id) {
		
		vestuarioService.Excluir(id);	
		
		return "redirect:/vestuario/lista";
	}
	
	@GetMapping(value = "/vestuario/lista")
	public String obterListaVestuario(Model model) {

		carregaDadosGrid(model);
		model.addAttribute("listagem", vestuarioService.ObterLista());
		model.addAttribute("searchFilter", "marca");	

		return appController.showHome(model);
	}
}
