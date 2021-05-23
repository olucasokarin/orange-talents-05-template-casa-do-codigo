package br.com.zupedu.olucas.casadocodigo.validators;

import br.com.zupedu.olucas.casadocodigo.locality.request.StateRequest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class UniqueStatePerCountryValidator implements ConstraintValidator<UniqueStatePerCountry, StateRequest> {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public boolean isValid(StateRequest value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from State s where s.name = :name and s.country.id = :id");
        query.setParameter("name", value.getName());
        query.setParameter("id", value.getCountryId());

        List<?> result = query.getResultList();
        return result.isEmpty();
    }
}
