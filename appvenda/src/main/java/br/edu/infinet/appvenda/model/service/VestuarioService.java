package br.edu.infinet.appvenda.model.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Vestuario;
import br.edu.infinet.appvenda.model.repository.IVesturarioRepository;

@Service
public class VestuarioService {

	@Autowired
	private IVesturarioRepository vestuarioRepository;
	
	public Collection<Vestuario> ObterLista() {
		return (Collection<Vestuario>) vestuarioRepository.findAll();
	}

	public void incluir(Vestuario vestuario) {
		vestuarioRepository.save(vestuario);
	}
}
