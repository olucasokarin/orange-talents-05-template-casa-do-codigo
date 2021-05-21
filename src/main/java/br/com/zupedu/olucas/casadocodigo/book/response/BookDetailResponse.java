package br.com.zupedu.olucas.casadocodigo.book.response;

import br.com.zupedu.olucas.casadocodigo.author.model.Author;
import br.com.zupedu.olucas.casadocodigo.author.response.AuthorDetailResponse;
import br.com.zupedu.olucas.casadocodigo.book.model.Book;
import br.com.zupedu.olucas.casadocodigo.category.model.Category;
import br.com.zupedu.olucas.casadocodigo.category.response.CategoryDetailResponse;
import org.hibernate.validator.constraints.ISBN;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class BookDetailResponse {
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    @Max(500)
    private String resume;
    private String summary;
    @NotNull
    @Min(20)
    private BigDecimal price;
    @NotNull
    @Min(100)
    @Positive
    private Integer numberPage;
    @NotBlank
    @ISBN
    private String isbn;
    private LocalDateTime publishDate;
    @NotNull
    private AuthorDetailResponse author;
    @NotNull
    private CategoryDetailResponse category;

    public BookDetailResponse(Long id, String title, String resume, String summary,
                              BigDecimal price, Integer numberPage, String isbn, LocalDateTime publishDate,
                              AuthorDetailResponse author, CategoryDetailResponse category) {
        this.id = id;
        this.title = title;
        this.resume = resume;
        this.summary = summary;
        this.price = price;
        this.numberPage = numberPage;
        this.isbn = isbn;
        this.publishDate = publishDate;
        this.author = author;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSummary() {
        return summary;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Integer getNumberPage() {
        return numberPage;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDateTime getPublishDate() {
        return publishDate;
    }

    public AuthorDetailResponse getAuthor() {
        return author;
    }

    public CategoryDetailResponse getCategory() {
        return category;
    }

    public static BookDetailResponse convertEntityToResponse(Book book) {
        @NotNull Author author = book.getAuthor();
        if (author == null) return null;

        @NotNull Category category = book.getCategory();
        if (category == null) return null;

        AuthorDetailResponse authorDetail = AuthorDetailResponse.convertEntityToResponse(author);
        CategoryDetailResponse categoryDetail = CategoryDetailResponse.convertEntityToResponse(category);

        BookDetailResponse bookDetail = new BookDetailResponse(book.getId(), book.getTitle(), book.getResume(),
                book.getSummary(), book.getPrice(), book.getNumberPage(), book.getIsbn(), book.getPublishDate(), authorDetail, categoryDetail);

        return bookDetail;
    }
}
