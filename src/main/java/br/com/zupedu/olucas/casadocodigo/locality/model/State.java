package br.com.zupedu.olucas.casadocodigo.locality.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String name;
    @ManyToOne
    private Country country;

    @Deprecated
    public State() {
    }

    public State(String name, Country country) {
        this.name = name;
        this.country = country;
    }
}
