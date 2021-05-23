package br.com.zupedu.olucas.casadocodigo.locality.controller;

import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import br.com.zupedu.olucas.casadocodigo.locality.model.State;
import br.com.zupedu.olucas.casadocodigo.locality.repository.CountryRepository;
import br.com.zupedu.olucas.casadocodigo.locality.repository.StateRepository;
import br.com.zupedu.olucas.casadocodigo.locality.request.StateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api/states")
public class StateController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    StateRepository stateRepository;

    @PostMapping
    public ResponseEntity createState(@RequestBody @Valid StateRequest stateRequest) {
        Integer checkNumberOne = stateRepository.findByNameAndCountry(stateRequest.getName(),
                stateRequest.getCountryId());
        if(checkNumberOne != null)
            return new ResponseEntity("State already existsg", HttpStatus.BAD_REQUEST);

        Optional<Country> countryOptional = countryRepository.findById(stateRequest.getCountryId());
        if(countryOptional.isEmpty())
            return new ResponseEntity("Country not found", HttpStatus.NOT_FOUND);

        Country country = countryOptional.get();
        State state = new State(stateRequest.getName(), country);
        stateRepository.save(state);

        return ResponseEntity.ok().build();
    }
}
