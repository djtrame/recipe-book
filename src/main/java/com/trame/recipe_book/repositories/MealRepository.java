package com.trame.recipe_book.repositories;

import com.trame.recipe_book.entities.MealEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<MealEntity, Integer> {


}
