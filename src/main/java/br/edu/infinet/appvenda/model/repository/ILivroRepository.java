package br.edu.infinet.appvenda.model.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.infinet.appvenda.model.domain.Livro;

@Repository
public interface ILivroRepository extends CrudRepository<Livro, Integer> {

	List<Livro> findByNome(String nome);
}
