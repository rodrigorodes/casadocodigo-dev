package br.com.casadocodigo.features.category.createcategory;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.casadocodigo.entity.Category;

@RestController
@RequestMapping("/v1/category")
public class CreateCategoryAPI {
	
	private CreateCategoryRepository repository;

	public CreateCategoryAPI(CreateCategoryRepository repository) {
		this.repository = repository;
	}

	@PostMapping("create")
	public ResponseEntity<?> create(@Valid @RequestBody CreateCategoryRequest request){
		
		Category newCategory = request.toModel();
		
		repository.save(newCategory);
		
		return ResponseEntity.ok().build();
		
	}
}
