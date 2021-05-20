package br.com.zupedu.olucas.casadocodigo.category.controller;

import br.com.zupedu.olucas.casadocodigo.category.model.Category;
import br.com.zupedu.olucas.casadocodigo.category.repository.CategoryRepository;
import br.com.zupedu.olucas.casadocodigo.category.request.CategoryRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping
    public ResponseEntity createCategory(@RequestBody @Valid CategoryRequest categoryRequest){
        Category category = categoryRequest.convertRequestToEntity();
        categoryRepository.save(category);
        return ResponseEntity.ok().build();
    }
}
