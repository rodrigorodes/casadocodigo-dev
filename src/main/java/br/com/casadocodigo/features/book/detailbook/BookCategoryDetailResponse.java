package br.com.casadocodigo.features.book.detailbook;

import br.com.casadocodigo.entity.Category;

public class BookCategoryDetailResponse {

	private final Long id;

	private final String name;

	public BookCategoryDetailResponse(Category category) {
		this.id = category.getId();
		this.name = category.getName();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
