package br.com.zupedu.olucas.casadocodigo.locality.request;

import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import br.com.zupedu.olucas.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.NotBlank;

public class CountryRequest {
    @NotBlank
    @UniqueValue(entity = Country.class, attribute = "name")
    private String name;

    public String getName() {
        return name;
    }
}
