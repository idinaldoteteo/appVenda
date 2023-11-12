package br.edu.infinet.appvenda.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.repository.IVendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private IVendedorRepository repository;
	
	public Collection<Vendedor> ObterLista() {
		return (Collection<Vendedor>) repository.findAll();
	}

	public void incluir(Vendedor vendedor) {		
		repository.save(vendedor);
	}
	
	public long obterQtde() {
		return repository.count();
	}

	public void Excluir(Integer id) {
		repository.deleteById(id);
	}
	
}
