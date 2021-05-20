package br.com.zupedu.olucas.casadocodigo.author.repository;

import br.com.zupedu.olucas.casadocodigo.author.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
