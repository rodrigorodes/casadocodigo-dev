package br.com.casadocodigo.features.book.detailbook;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.entity.Book;

@Repository
public interface BookDetailRepository extends JpaRepository<Book, Long> {

}
