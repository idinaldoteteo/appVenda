package br.edu.infinet.appvenda.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(url = "http://localhost:8081/api/venda", name = "vendaClient")
public interface IVendaClient {

	@GetMapping(value = "/informacoes")
	public List<String> obterInformacoes();
}
