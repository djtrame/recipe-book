package com.trame.recipe_book.services;

import com.trame.recipe_book.entities.IngredientEntity;
import com.trame.recipe_book.entities.MealEntity;

import java.util.List;
import java.util.Optional;

public interface IngredientService {
    IngredientEntity save(IngredientEntity ingredientEntity);

    Optional<IngredientEntity> findOne(Integer ingredient_id);

    List<IngredientEntity> findAll();
}
