package br.com.zupedu.olucas.casadocodigo.client.model;

import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import br.com.zupedu.olucas.casadocodigo.locality.model.State;
import br.com.zupedu.olucas.casadocodigo.validators.CPFOrCNPJ;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    @NotNull
    private String lastname;
    @CPFOrCNPJ
    @Column(unique = true)
    private String document;
    @NotNull
    private String address;
    @NotNull
    private String complement;
    @NotNull
    private String city;
    @NotNull
    @ManyToOne
    private Country country;
    @ManyToOne
    private State state;
    @NotNull
    private String telephone;
    @NotNull
    private String cep;

    @Deprecated
    public Client() {
    }

    public Client(String name, String email, String lastname,
                  String document, String address, String complement, String city,
                  Country country, String telephone, String cep) {
        this.name = name;
        this.email = email;
        this.lastname = lastname;
        this.document = document;
        this.address = address;
        this.complement = complement;
        this.city = city;
        this.country = country;
        this.telephone = telephone;
        this.cep = cep;
    }

    public void setState(State state) {
        this.state = state;
    }
}
