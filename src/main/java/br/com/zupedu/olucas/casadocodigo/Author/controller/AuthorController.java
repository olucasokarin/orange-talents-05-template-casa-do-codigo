package br.com.zupedu.olucas.casadocodigo.author.controller;

import br.com.zupedu.olucas.casadocodigo.author.model.Author;
import br.com.zupedu.olucas.casadocodigo.author.repository.AuthorRepository;
import br.com.zupedu.olucas.casadocodigo.author.request.AuthorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @PostMapping
    public ResponseEntity createAuthor(@RequestBody @Valid AuthorRequest authorRequest) {
        Author author = authorRequest.convertRequestToEntity();
        authorRepository.save(author);
        return ResponseEntity.ok().build();
    }
}
