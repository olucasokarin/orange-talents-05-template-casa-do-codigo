package br.com.zupedu.olucas.casadocodigo.client.controller;

import br.com.zupedu.olucas.casadocodigo.client.model.Client;
import br.com.zupedu.olucas.casadocodigo.client.request.ClientRequest;
import br.com.zupedu.olucas.casadocodigo.locality.repository.ClientRepository;
import br.com.zupedu.olucas.casadocodigo.locality.repository.CountryRepository;
import br.com.zupedu.olucas.casadocodigo.locality.repository.StateRepository;
import br.com.zupedu.olucas.casadocodigo.validators.VerifyExistStateInCountry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    StateRepository stateRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    VerifyExistStateInCountry existStateInCountry;

    @PostMapping
    public ResponseEntity createClient(@RequestBody @Valid ClientRequest clientRequest) {
        Client client = clientRequest.convertRequestToEntity(countryRepository, stateRepository);
        clientRepository.save(client);
        return ResponseEntity.ok().build();
    }

    @InitBinder
    public void init(WebDataBinder webDataBinder){
        webDataBinder.addValidators(existStateInCountry);
    }
}
