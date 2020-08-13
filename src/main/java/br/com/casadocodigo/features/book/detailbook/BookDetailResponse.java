package br.com.casadocodigo.features.book.detailbook;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.casadocodigo.entity.Book;

public class BookDetailResponse {

	private final String title;

	private final String resume;

	private final String sumary;

	private final BigDecimal price;

	private final Integer pageNumber;

	private final String isbn;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateLaunch;

	@JsonProperty("author")
	private BookAuthorDetailResponse bookAuthorDetailResponse;
	
	@JsonProperty("category")
	private BookCategoryDetailResponse bookCategoryDetailResponse;

	public BookDetailResponse(Book book) {
		this.title = book.getTitle();
		this.resume = book.getResume();
		this.sumary = book.getSumary();
		this.price = book.getPrice();
		this.pageNumber = book.getPageNumber();
		this.isbn = book.getIsbn();
		this.dateLaunch = book.getDateLaunch();
		this.bookCategoryDetailResponse = new BookCategoryDetailResponse(book.getCategory());
		this.bookAuthorDetailResponse = new BookAuthorDetailResponse(book.getAuthor());
	}

	public String getTitle() {
		return title;
	}

	public String getResume() {
		return resume;
	}

	public String getSumary() {
		return sumary;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getDateLaunch() {
		return dateLaunch;
	}

}
