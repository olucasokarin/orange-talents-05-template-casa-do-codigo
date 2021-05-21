package br.com.zupedu.olucas.casadocodigo.book.model;

import br.com.zupedu.olucas.casadocodigo.author.model.Author;
import br.com.zupedu.olucas.casadocodigo.category.model.Category;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String title;
    @NotNull
    @Column(length = 500)
    private String resume;
    @Lob
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
    @Column(unique = true)
    private String isbn;
    @Future
    @NotNull
    private LocalDateTime publishDate;
    @NotNull
    @ManyToOne
    private Category category;
    @NotNull
    @ManyToOne
    private Author author;

    @Deprecated
    public Book() {
    }

    public Book(String title, String resume, String summary, BigDecimal price,
                Integer numberPage, String isbn, LocalDateTime publishDate,
                Category category, Author author) {
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPage = numberPage;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
