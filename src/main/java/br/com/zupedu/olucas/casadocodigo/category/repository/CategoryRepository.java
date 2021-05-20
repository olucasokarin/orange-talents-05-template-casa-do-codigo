package br.com.zupedu.olucas.casadocodigo.category.repository;

import br.com.zupedu.olucas.casadocodigo.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
