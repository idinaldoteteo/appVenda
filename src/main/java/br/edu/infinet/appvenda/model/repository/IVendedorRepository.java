package br.edu.infinet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.appvenda.model.domain.Vendedor;

@Repository
public interface IVendedorRepository extends CrudRepository<Vendedor, Integer> {

	List<Vendedor> findAll(Sort sort);
	
	Vendedor findByCpf(String cpf);
}
