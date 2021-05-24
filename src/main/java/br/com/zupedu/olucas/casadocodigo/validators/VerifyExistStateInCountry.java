package br.com.zupedu.olucas.casadocodigo.validators;

import br.com.zupedu.olucas.casadocodigo.client.request.ClientRequest;
import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import br.com.zupedu.olucas.casadocodigo.locality.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.stream.Collectors;

@Configuration
public class VerifyExistStateInCountry implements Validator {

    @Autowired
    CountryRepository countryRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return ClientRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }

        ClientRequest request = (ClientRequest) target;

        Country country = countryRepository.findByName(request.getCountry());;

        if(country.getState().size() > 0 && request.getState() == null)
            errors.rejectValue("state", null, "State is mandatory");

        if(country.getState().size() > 0 && request.getState() != null) {
            country.getState().stream()
                    .filter(state -> state.getName().equals(request.getState()))
                    .collect(Collectors.collectingAndThen(Collectors.toList(), list -> {
                        if(list.size() != 1)
                            errors.rejectValue("state", null,
                                    "Is no such state in that country");
                        return null;
                    }));
        }

    }
}
