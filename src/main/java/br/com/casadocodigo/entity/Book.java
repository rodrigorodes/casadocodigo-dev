package br.com.casadocodigo.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(unique = true, length = 250)
	@NotBlank
	@Size(max = 250)
	private String title;

	@Column(length = 500)
	@NotBlank
	@Size(max = 500)
	private String resume;

	@Lob
	private String sumary;

	@Column(precision = 6, scale = 2)
	@NotNull
	@Digits(integer = 6, fraction = 2)
	@DecimalMin("20.00")
	private BigDecimal price;

	@NotNull
	@Min(100)
	private Integer pageNumber;

	@Column(length = 17, unique = true)
	@NotBlank
	//@Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$")
	private String isbn;

	@Future
	@NotNull
	private LocalDate dateLaunch;

	@ManyToOne(optional = false)
	@JoinColumn(name = "category_id")
	@NotNull
	private Category category;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "author_id")
	@NotNull
	private Author author;
	
	@Deprecated
	public Book() {
	}
	
	public Book(@NotBlank @Size(max = 250) String title,
			@NotBlank @Size(max = 500) String resume, 
			String sumary,
			@NotNull @Digits(integer = 6, fraction = 2) 
			@DecimalMin("20.00") BigDecimal price,
			@NotNull @Min(100) Integer pageNumber,
			@NotBlank @Pattern(regexp = "^(?:ISBN(?:-1[03])?:? )?(?=[0-9X]{10}$|(?=(?:[0-9]+[- ]){3})[- 0-9X]{13}$|97[89][0-9]{10}$|(?=(?:[0-9]+[- ]){4})[- 0-9]{17}$)(?:97[89][- ]?)?[0-9]{1,5}[- ]?[0-9]+[- ]?[0-9]+[- ]?[0-9X]$") String isbn,
			@Future @NotNull LocalDate dateLaunch, 
			@NotNull Category category, 
			@NotNull
			Author author) {
		this.title = title;
		this.resume = resume;
		this.sumary = sumary;
		this.price = price;
		this.pageNumber = pageNumber;
		this.isbn = isbn;
		this.dateLaunch = dateLaunch;
		this.category = category;
		this.author = author;
	}

	public Long getId() {
		return id;
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

	public Category getCategory() {
		return category;
	}
	
	public Author getAuthor() {
		return author;
	}

}
