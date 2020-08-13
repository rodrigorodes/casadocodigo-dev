package br.com.casadocodigo.features.category.createcategory;

import javax.validation.constraints.NotBlank;

import br.com.casadocodigo.commons.validators.UniqueValue;
import br.com.casadocodigo.entity.Category;

public class CreateCategoryRequest {

	@NotBlank
	@UniqueValue(domainAttribute = "name", klass = Category.class)
	private String name;

	public String getName() {
		return name;
	}

	public Category toModel() {
		return new Category(name);
	}


}
