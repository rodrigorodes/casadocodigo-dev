package br.com.casadocodigo.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(length = 50, nullable = false)
	@NotBlank
	@Size(max = 50)
	private String name;

	@Column(length = 400, nullable = false)
	@NotBlank
	@Size(max = 400)
	private String description;

	@Column(length = 256, nullable = false, unique = true)
	@NotBlank
	@Size(max = 256)
	@Email
	private String mail;

	@CreationTimestamp
	@Column(name = "created_at", columnDefinition = "TIMESTAMP")
	private LocalDateTime createdAt;

	@Deprecated
	public Author() {
	}

	public Author(@NotBlank @Size(max = 50) String name,
	                 @NotBlank @Size(max = 400) String description,
	                 @NotBlank @Size(max = 256) @Email String mail) {
	        this.name = name;
	        this.description = description;
	        this.mail = mail;
	        this.createdAt = LocalDateTime.now();
	    }

	public Long getId() {
		return id;
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

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

}
