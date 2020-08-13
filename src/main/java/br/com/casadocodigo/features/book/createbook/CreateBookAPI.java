package br.com.casadocodigo.features.book.createbook;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.entity.Book;

@RestController
@RequestMapping("v1/book")
public class CreateBookAPI {
	
	@PersistenceContext
	private EntityManager manager;

	private CreateBookRepository createBookRepository;

	public CreateBookAPI(CreateBookRepository createBookRepository) {
		this.createBookRepository = createBookRepository;
	}

	@PostMapping("create")
	public ResponseEntity<?> create(@Valid @RequestBody CreateBookRequest request) {

		Book book = request.toModel(manager);

		createBookRepository.save(book);

		return ResponseEntity.ok().build();
	}
}
