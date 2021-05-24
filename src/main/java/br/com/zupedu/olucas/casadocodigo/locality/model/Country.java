package br.com.zupedu.olucas.casadocodigo.locality.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "country")
    private List<State> state;

    @Deprecated
    public Country() {
    }

    public Country(String name) {
        this.name = name;
    }

    public List<State> getState() {
        return state;
    }
}
