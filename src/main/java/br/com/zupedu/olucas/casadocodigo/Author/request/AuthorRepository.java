package br.com.zupedu.olucas.casadocodigo.Author.request;

import br.com.zupedu.olucas.casadocodigo.Author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
