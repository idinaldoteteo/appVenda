package br.edu.infinet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.appvenda.model.domain.Vendedor;

@Repository
public interface IVendedorRepository extends CrudRepository<Vendedor, Integer> {

}
