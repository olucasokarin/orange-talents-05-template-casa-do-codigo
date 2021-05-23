package br.com.zupedu.olucas.casadocodigo.locality.repository;

import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
