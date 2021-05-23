package br.com.zupedu.olucas.casadocodigo.locality.repository;

import br.com.zupedu.olucas.casadocodigo.locality.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {
    @Query("select 1 from State s where s.name = :name and s.country.id = :id")
    Integer findByNameAndCountry(String name, Long id);
}
