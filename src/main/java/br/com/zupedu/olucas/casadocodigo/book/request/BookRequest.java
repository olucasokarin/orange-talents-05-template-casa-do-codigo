package br.com.zupedu.olucas.casadocodigo.book.request;

import br.com.zupedu.olucas.casadocodigo.author.model.Author;
import br.com.zupedu.olucas.casadocodigo.author.repository.AuthorRepository;
import br.com.zupedu.olucas.casadocodigo.book.model.Book;
import br.com.zupedu.olucas.casadocodigo.category.model.Category;
import br.com.zupedu.olucas.casadocodigo.category.repository.CategoryRepository;
import br.com.zupedu.olucas.casadocodigo.validators.Exists;
import br.com.zupedu.olucas.casadocodigo.validators.UniqueValue;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BookRequest {

    @NotBlank
    @UniqueValue(entity = Book.class, attribute = "title")
    private String title;
    @NotBlank
    private String resume;
    @NotBlank
    private String summary;
    @NotNull
    @Min(20)
    private BigDecimal price;
    @NotNull
    @Min(100)
    @Positive
    private Integer numberPage;
    @NotNull
    @ISBN
    @UniqueValue(entity = Book.class, attribute = "isbn")
    private String isbn;
    @NotNull
    @Future
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:s", shape = JsonFormat.Shape.STRING)
    private LocalDateTime publishDate;
    @NotNull
    @Exists(entity = Category.class)
    private Long categoryId;
    @NotNull
    @Exists(entity = Author.class)
    private Long authorId;

    public BookRequest(String title, String resume, String summary,
                       BigDecimal price, Integer numberPage, String isbn,
                       Long categoryId, Long authorId) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPage = numberPage;
        this.isbn = isbn;
        this.categoryId = categoryId;
        this.authorId = authorId;
    }

    public void setPublishDate(LocalDateTime publishDate) {
        this.publishDate = publishDate;
    }

    public Book convertRequestToEntity(AuthorRepository authorRepository,
                                       CategoryRepository categoryRepository) {
        @NotNull Author author = authorRepository.findById(this.authorId).get();
        @NotNull Category category = categoryRepository.findById(this.categoryId).get();

        return new Book(this.title, this.resume, this.summary, this.price,
                        this.numberPage, this.isbn, this.publishDate, category, author);
    }
}
