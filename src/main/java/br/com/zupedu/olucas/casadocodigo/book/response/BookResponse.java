package br.com.zupedu.olucas.casadocodigo.book.response;

import br.com.zupedu.olucas.casadocodigo.book.model.Book;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;

public class BookResponse {
    @NotNull
    private Long id;
    @NotNull
    private String title;

    public BookResponse(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static List<BookResponse> convertEntityToResponse(List<Book> books) {
        return books.stream().map(book ->
            new BookResponse(book.getId(), book.getTitle())
        ).collect(Collectors.toList());
    }
}
