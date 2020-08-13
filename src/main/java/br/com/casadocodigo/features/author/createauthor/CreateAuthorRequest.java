package br.com.casadocodigo.features.author.createauthor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import br.com.casadocodigo.commons.validators.UniqueValue;
import br.com.casadocodigo.entity.Author;

public class CreateAuthorRequest {

	@NotBlank
	@Size(max = 50)
	private String name;

	@NotBlank
	@Size(max = 400)
	private String description;

	@Size(max = 256)
	@Email
	@NotBlank
	@UniqueValue(domainAttribute = "mail", klass = Author.class, message = "E-mail Já existe")
	private String mail;

	public CreateAuthorRequest(
			@NotBlank @Size(max = 50) String name, 
			@NotBlank @Size(max = 400) String description,
			@Size(max = 256) @Email @NotBlank String mail) {
		this.name = name;
		this.description = description;
		this.mail = mail;
	}

	public Author toModel() {
		return new Author(this.name, this.description, this.mail);
	}

	public String getMail() {
		return mail;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
