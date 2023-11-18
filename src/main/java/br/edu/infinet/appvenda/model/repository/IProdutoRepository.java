package br.edu.infinet.appvenda.model.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.appvenda.model.domain.Produto;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Integer> {

	@Query("from Produto p where p.vendedor.id = :vendedorId")
	Collection<Produto> ObterLista(Integer vendedorId);
	
	List<Produto> findByCodigo(Integer codigo);
}
