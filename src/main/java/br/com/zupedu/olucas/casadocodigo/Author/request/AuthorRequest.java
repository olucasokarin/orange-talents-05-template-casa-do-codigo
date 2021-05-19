package br.com.zupedu.olucas.casadocodigo.Author.request;

import br.com.zupedu.olucas.casadocodigo.Author.model.Author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AuthorRequest {
    @NotBlank
    private String name;
    @Email
    @NotBlank
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
