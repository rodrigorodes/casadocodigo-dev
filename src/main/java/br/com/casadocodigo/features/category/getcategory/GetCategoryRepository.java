package br.com.casadocodigo.features.category.getcategory;

import org.springframework.data.repository.CrudRepository;

import br.com.casadocodigo.entity.Category;

public interface GetCategoryRepository extends CrudRepository<Category, Long>{

}
