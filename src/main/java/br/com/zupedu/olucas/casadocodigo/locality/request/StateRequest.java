package br.com.zupedu.olucas.casadocodigo.locality.request;

import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import br.com.zupedu.olucas.casadocodigo.validators.Exists;
import br.com.zupedu.olucas.casadocodigo.validators.UniqueStatePerCountry;

import javax.validation.constraints.NotNull;

//@UniqueStatePerCountry
public class StateRequest {
    @NotNull
    @Exists(entity = Country.class)
    private Long countryId;
    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }
}
