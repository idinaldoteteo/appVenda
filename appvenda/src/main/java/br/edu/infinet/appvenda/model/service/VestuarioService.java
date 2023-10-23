package br.edu.infinet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Vestuario;

@Service
public class VestuarioService {

	private Map<Integer, Vestuario> vestuarioMap = new HashMap<Integer, Vestuario>();
	
	public Collection<Vestuario> ObterLista() {
		return vestuarioMap.values();
	}

	public void incluir(Vestuario produto) {
		vestuarioMap.put(produto.getCodigo(), produto);
	}
}
