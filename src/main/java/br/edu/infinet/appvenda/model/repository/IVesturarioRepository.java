package br.edu.infinet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.appvenda.model.domain.Vestuario;

@Repository
public interface IVesturarioRepository extends CrudRepository<Vestuario, Integer> {

	List<Vestuario> findByMarca(String nome);
}
