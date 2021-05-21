package br.com.zupedu.olucas.casadocodigo.category.response;

import br.com.zupedu.olucas.casadocodigo.category.model.Category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoryDetailResponse {
    @NotNull
    private Long id;
    @NotBlank
    private String name;

    public CategoryDetailResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static CategoryDetailResponse convertEntityToResponse(Category category) {
        return new CategoryDetailResponse(category.getId(), category.getName());
    }
}
