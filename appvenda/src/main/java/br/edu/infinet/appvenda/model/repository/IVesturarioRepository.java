package br.edu.infinet.appvenda.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.appvenda.model.domain.Vestuario;

@Repository
public interface IVesturarioRepository extends CrudRepository<Vestuario, Integer> {

}
