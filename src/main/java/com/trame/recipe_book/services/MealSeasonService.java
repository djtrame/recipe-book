package com.trame.recipe_book.services;

import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.entities.MealSeasonEntity;
import com.trame.recipe_book.entities.SeasonEntity;

import java.util.List;
import java.util.Optional;

public interface MealSeasonService {
    MealSeasonEntity save(MealSeasonEntity mealSeasonEntity);

//    Optional<MealSeasonEntity> findOne(Integer meal_id, Integer season_id);

    List<MealSeasonEntity> findAll();

    MealSeasonEntity linkMealToSeason(MealEntity mealEntity, SeasonEntity seasonEntity);

}
