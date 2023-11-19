package br.edu.infinet.appvenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.edu.infinet.appvenda.model.domain.Informacao;

@FeignClient(url = "http://localhost:8081/api/informacao", name = "informacaoClient")
public interface IInformacaoClient {

	@GetMapping(value = "/lista")
	public List<Informacao> obterLista();
	
	@PostMapping(value = "/incluir")
	public Informacao incluir(Informacao informacao);
	
	@GetMapping(value = "/excluir/{id}")
	public void excluir(@PathVariable Integer id);
}
