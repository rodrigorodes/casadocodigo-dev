package br.com.casadocodigo.features.author.createauthor;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.entity.Author;

@RestController
@RequestMapping("/v1/author")
public class CreateAuthorAPI {

	private CreateAuthorRepository repository;

	public CreateAuthorAPI(CreateAuthorRepository repository) {
		this.repository = repository;
	}

	@PostMapping(value = "create")
	public ResponseEntity<?> createAuth(@Valid @RequestBody CreateAuthorRequest request) {
		
		Author newAuthor = request.toModel();
		repository.save(newAuthor);
		
		return ResponseEntity.ok().build();
	}

}
