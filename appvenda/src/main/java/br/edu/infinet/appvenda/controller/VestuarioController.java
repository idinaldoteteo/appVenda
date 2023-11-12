package br.edu.infinet.appvenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.edu.infinet.appvenda.model.service.VestuarioService;

@Controller
public class VestuarioController {

	@Autowired
	private AppController appController;
	
	@Autowired
	private VestuarioService vestuarioService;
	
	@GetMapping(value = "/vestuario/{id}/excluir")
	public String Excluir(@PathVariable Integer id, Model model) {
		
		vestuarioService.Excluir(id);
		
		model.addAttribute("qtdeVestuario", vestuarioService.obterQtde());
		
		return "redirect:/vestuario/lista";
	}
	
	@GetMapping(value = "/vestuario/lista")
	public String obterListaVestuario(Model model) {

		model.addAttribute("rota", "vestuario");
		model.addAttribute("titulo", "Vestuário");
		model.addAttribute("listagem", vestuarioService.ObterLista());

		return appController.showHome(model);
	}
}
