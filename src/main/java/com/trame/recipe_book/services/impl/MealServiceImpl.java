package com.trame.recipe_book.services.impl;

import com.trame.recipe_book.entities.IngredientEntity;
import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.repositories.MealRepository;
import com.trame.recipe_book.services.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public MealEntity save(MealEntity mealEntity) {
        return mealRepository.save(mealEntity);
    }

    @Override
    public Optional<MealEntity> findOne(Integer meal_id) {
        return mealRepository.findById(meal_id);
    }

    @Override
    public List<MealEntity> findAll() {
        return StreamSupport.stream(mealRepository
                    .findAll()
                    .spliterator(),
                    false)
                .collect(Collectors.toList());
    }

    @Override
    public MealEntity linkMealToIngredient(MealEntity mealEntity, IngredientEntity ingredientEntity) {
        mealEntity.linkMealToIngredient(ingredientEntity);
        return mealRepository.save(mealEntity);
    }


}
