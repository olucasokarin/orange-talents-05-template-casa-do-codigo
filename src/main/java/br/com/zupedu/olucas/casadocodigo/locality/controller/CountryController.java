package br.com.zupedu.olucas.casadocodigo.locality.controller;

import br.com.zupedu.olucas.casadocodigo.locality.model.Country;
import br.com.zupedu.olucas.casadocodigo.locality.repository.CountryRepository;
import br.com.zupedu.olucas.casadocodigo.locality.request.CountryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/countries")
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @PostMapping
    public ResponseEntity createCountry(@RequestBody @Valid CountryRequest countryRequest) {
        Country country = new Country(countryRequest.getName());
        countryRepository.save(country);
        return ResponseEntity.ok().build();
    }
}
