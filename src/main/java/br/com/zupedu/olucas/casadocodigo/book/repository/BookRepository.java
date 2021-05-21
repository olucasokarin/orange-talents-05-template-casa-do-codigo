package br.com.zupedu.olucas.casadocodigo.book.repository;

import br.com.zupedu.olucas.casadocodigo.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
