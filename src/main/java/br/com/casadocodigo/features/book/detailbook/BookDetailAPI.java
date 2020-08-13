package br.com.casadocodigo.features.book.detailbook;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.entity.Book;

@RestController
@RequestMapping("v1/book")
public class BookDetailAPI {

	private BookDetailRepository detailBookRepository;

	public BookDetailAPI(BookDetailRepository detailBookRepository) {
		this.detailBookRepository = detailBookRepository;
	}

	@GetMapping("detail/{id}")
	public ResponseEntity<?> findDetailBook(@PathVariable("id") Long id) {

		Optional<Book> book = detailBookRepository.findById(id);

		if (!book.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Book bookDetail = book.get();
		
		BookDetailResponse detailBookResponse = new BookDetailResponse(bookDetail);

		return ResponseEntity.ok(detailBookResponse);

	}

}
