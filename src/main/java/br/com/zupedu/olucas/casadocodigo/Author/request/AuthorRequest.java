package br.com.zupedu.olucas.casadocodigo.author.request;

import br.com.zupedu.olucas.casadocodigo.author.model.Author;
import br.com.zupedu.olucas.casadocodigo.validators.Exists;
import br.com.zupedu.olucas.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {
    @NotBlank
    private String name;
    @Email
    @NotBlank
    @UniqueValue(entity = Author.class, attribute = "email")
    private String email;
    @NotBlank
    @Size(max = 400)
    private String description;

    public AuthorRequest(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
    }

    public Author convertRequestToEntity() {
        return new Author(this.name, this.email, this.description);
    }
}
