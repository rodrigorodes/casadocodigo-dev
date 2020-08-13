package br.com.casadocodigo.features.book.detailbook;

import br.com.casadocodigo.entity.Author;

public class BookAuthorDetailResponse {

	private final String name;

	private final String description;

	private final String mail;

	public BookAuthorDetailResponse(Author author) {
		this.name = author.getName();
		this.description = author.getDescription();
		this.mail = author.getMail();
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public String getMail() {
		return mail;
	}

}
