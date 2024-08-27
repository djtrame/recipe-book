package com.trame.recipe_book.repositories;

import com.trame.recipe_book.entities.MealSeasonEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealSeasonRepository extends CrudRepository<MealSeasonEntity, Integer> {


}
