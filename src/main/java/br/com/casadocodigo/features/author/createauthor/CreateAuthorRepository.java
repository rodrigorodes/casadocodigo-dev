package br.com.casadocodigo.features.author.createauthor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.entity.Author;

@Repository
public interface CreateAuthorRepository extends CrudRepository<Author, Long> {

}
