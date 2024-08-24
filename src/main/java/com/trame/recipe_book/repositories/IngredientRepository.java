package com.trame.recipe_book.repositories;

import com.trame.recipe_book.entities.IngredientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<IngredientEntity, Integer> {


}
