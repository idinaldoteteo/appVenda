package br.edu.infinet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Vendedor;

@Service
public class VendedorService {

	private Map<String, Vendedor> vendedorMap = new HashMap<String, Vendedor>();
	
	public Collection<Vendedor> ObterLista() {
		return vendedorMap.values();
	}

	public void incluir(Vendedor vendedor) {
		vendedorMap.put(vendedor.getCpf(), vendedor);
	}
}
