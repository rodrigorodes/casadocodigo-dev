package br.com.casadocodigo.features.book.createbook;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.casadocodigo.commons.validators.ExistsId;
import br.com.casadocodigo.commons.validators.UniqueValue;
import br.com.casadocodigo.entity.Author;
import br.com.casadocodigo.entity.Book;
import br.com.casadocodigo.entity.Category;

public class CreateBookRequest {

	@NotBlank
	@Size(max = 250)
	@UniqueValue(domainAttribute = "title", klass = Book.class)
	private String title;

	@NotBlank
	@Size(max = 500)
	private String resume;

	private String sumary;

	@NotNull
	@Digits(integer = 6, fraction = 2)
	@DecimalMin("20.00")
	private BigDecimal price;

	@NotNull
	@Min(100)
	private Integer pageNumber;

	@NotBlank
	//@Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
	private String isbn;

	@Future
	@NotNull
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
	private LocalDate dateLaunch;

	@NotNull
	@ExistsId(domainAttribute = "id", klass = Category.class)
	private Long categoryId;
	
	@NotNull
	@ExistsId(domainAttribute = "id", klass = Author.class)
	private Long authorId;

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

	public Long getCategoryId() {
		return categoryId;
	}
	
	public Long getAuthorId() {
		return authorId;
	}

	public Book toModel(EntityManager manager) {
		
		Category category = manager.find(Category.class, categoryId);
		Author author = manager.find(Author.class, authorId);
		
		Assert.state(category != null, "Category is null");
		Assert.state(author != null, "Author is null");

		return new Book(title, resume, sumary, price, pageNumber, isbn, dateLaunch, category ,author);
	}
}
