package com.trame.recipe_book.services;

import com.trame.recipe_book.entities.IngredientEntity;
import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.entities.SeasonEntity;

import java.util.List;
import java.util.Optional;

public interface MealService {
    MealEntity save(MealEntity mealEntity);

    Optional<MealEntity> findOne(Integer meal_id);

    List<MealEntity> findAll();

    MealEntity linkMealToIngredient(MealEntity mealEntity, IngredientEntity ingredientEntity);

//    MealEntity linkMealToSeason(MealEntity mealEntity, SeasonEntity seasonEntity);
}
