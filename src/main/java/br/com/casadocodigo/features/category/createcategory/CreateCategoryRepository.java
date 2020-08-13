package br.com.casadocodigo.features.category.createcategory;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.casadocodigo.entity.Category;

@Repository
public interface CreateCategoryRepository extends CrudRepository<Category, Long> {

}
