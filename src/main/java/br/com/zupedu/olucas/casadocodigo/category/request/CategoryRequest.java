package br.com.zupedu.olucas.casadocodigo.category.request;

import br.com.zupedu.olucas.casadocodigo.category.model.Category;
import br.com.zupedu.olucas.casadocodigo.validators.Exists;
import br.com.zupedu.olucas.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotBlank;

public class CategoryRequest {
    @NotBlank
    @UniqueValue(entity = Category.class, attribute = "name")
    private String name;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public CategoryRequest(String name) {
        this.name = name;
    }

    public Category convertRequestToEntity() {
        return new Category(this.name);
    }
}
