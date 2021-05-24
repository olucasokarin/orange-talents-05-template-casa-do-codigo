package br.com.zupedu.olucas.casadocodigo.client.request;

import br.com.zupedu.olucas.casadocodigo.client.model.Client;
import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import br.com.zupedu.olucas.casadocodigo.locality.model.State;
import br.com.zupedu.olucas.casadocodigo.locality.repository.CountryRepository;
import br.com.zupedu.olucas.casadocodigo.locality.repository.StateRepository;
import br.com.zupedu.olucas.casadocodigo.validators.CPFOrCNPJ;
import br.com.zupedu.olucas.casadocodigo.validators.Exists;
import br.com.zupedu.olucas.casadocodigo.validators.UniqueValue;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ClientRequest {
    @NotBlank
    private String name;
    @NotBlank
    @Email
    @UniqueValue(entity = Client.class, attribute = "email")
    private String email;
    @NotBlank
    private String lastname;
    @CPFOrCNPJ
    @NotNull
    @UniqueValue(entity = Client.class, attribute = "document")
    private String document;
    @NotBlank
    private String address;
    @NotBlank
    private String complement;
    @NotBlank
    private String city;

    @NotBlank
    @Exists(entity = Country.class, attribute = "name")
    private String country;
    private String state;

    @NotBlank
    private String telephone;
    @NotBlank
    private String cep;


    public ClientRequest(String name, String email, String lastname, String document, String address,
                         String complement, String city, String country, String state,
                         String telephone, String cep) {
        this.name = name;
        this.email = email;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.state = state;
        this.telephone = telephone;
        this.cep = cep;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public Client convertRequestToEntity(CountryRepository countryRepository,
                                         StateRepository stateRepository) {
        Country country = countryRepository.findByName(this.country);
        Client client = new Client(this.name, this.email, this.lastname, this.document, this.address, this.complement,
                this.city, country, this.telephone, this.cep);

        if(country.getState().size() > 0) {
            State state = stateRepository.findByName(this.state);
            client.setState(state);
        }

        return client;
    }
}
