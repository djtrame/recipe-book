package com.trame.recipe_book.services.impl;

import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.repositories.MealRepository;
import com.trame.recipe_book.services.MealService;
import org.springframework.stereotype.Service;

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
}
