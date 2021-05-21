package br.com.zupedu.olucas.casadocodigo.author.response;

import br.com.zupedu.olucas.casadocodigo.author.model.Author;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;

public class AuthorDetailResponse {
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    @Max(400)
    private String description;

    public AuthorDetailResponse(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    public static AuthorDetailResponse convertEntityToResponse(Author author) {
        return new AuthorDetailResponse(author.getId(), author.getName(), author.getDescription());
    }
}
