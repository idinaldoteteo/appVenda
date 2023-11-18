package br.edu.infinet.appvenda.model.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.edu.infinet.appvenda.clients.IEnderecoClient;
import br.edu.infinet.appvenda.clients.IInformacaoClient;
import br.edu.infinet.appvenda.model.domain.Endereco;
import br.edu.infinet.appvenda.model.domain.Vendedor;
import br.edu.infinet.appvenda.model.repository.IVendedorRepository;

@Service
public class VendedorService {

	@Autowired
	private IVendedorRepository repository;
	
	@Autowired
	private IEnderecoClient enderecoClient;
		
	public Vendedor pesquisar(String campoBusca) {
		
		return repository.findByCpf(campoBusca);
	}
	
	public Collection<Vendedor> ObterLista() {
		return (Collection<Vendedor>) repository.findAll(Sort.by(Sort.Direction.ASC, "nome"));
	}

	public void incluir(Vendedor vendedor) {	
		Endereco endereco = enderecoClient.buscarCep(vendedor.getEndereco().getCep());
		
		vendedor.setEndereco(endereco);
		
		repository.save(vendedor);
	}
	
	public long obterQtde() {
		return repository.count();
	}

	public void Excluir(Integer id) {
		repository.deleteById(id);
	}
	
}
