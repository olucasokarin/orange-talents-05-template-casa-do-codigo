package br.com.zupedu.olucas.casadocodigo.book.controller;

import br.com.zupedu.olucas.casadocodigo.author.repository.AuthorRepository;
import br.com.zupedu.olucas.casadocodigo.book.model.Book;
import br.com.zupedu.olucas.casadocodigo.book.repository.BookRepository;
import br.com.zupedu.olucas.casadocodigo.book.request.BookRequest;
import br.com.zupedu.olucas.casadocodigo.book.response.BookDetailResponse;
import br.com.zupedu.olucas.casadocodigo.book.response.BookResponse;
import br.com.zupedu.olucas.casadocodigo.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    BookRepository bookRepository;

    @PostMapping
    public ResponseEntity createBook(@RequestBody @Valid BookRequest bookRequest) {
        Book book = bookRequest.convertRequestToEntity(authorRepository, categoryRepository);
        bookRepository.save(book);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BookResponse>> getBooks() {
        List<Book> books = bookRepository.findAll();
        return ResponseEntity.ok(BookResponse.convertEntityToResponse(books));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailResponse> getBook(@PathVariable Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isEmpty()) return new ResponseEntity("Book not found", HttpStatus.NOT_FOUND);
        Book book = bookOptional.get();

        @NotNull BookDetailResponse bookDetail = BookDetailResponse.convertEntityToResponse(book);
        if (bookDetail == null) return new ResponseEntity(HttpStatus.BAD_REQUEST);

        return ResponseEntity.ok(bookDetail);
    }
}
