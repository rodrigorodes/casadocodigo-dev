package br.com.casadocodigo.features.book.createbook;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.entity.Book;

@Repository
public interface CreateBookRepository extends CrudRepository<Book, Long> {

}
