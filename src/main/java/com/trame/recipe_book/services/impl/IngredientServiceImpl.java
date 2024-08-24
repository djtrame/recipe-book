package com.trame.recipe_book.services.impl;

import com.trame.recipe_book.entities.IngredientEntity;
import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.repositories.IngredientRepository;
import com.trame.recipe_book.repositories.MealRepository;
import com.trame.recipe_book.services.IngredientService;
import com.trame.recipe_book.services.MealService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class IngredientServiceImpl implements IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientServiceImpl(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public IngredientEntity save(IngredientEntity ingredientEntity) {
        return ingredientRepository.save(ingredientEntity);
    }

    @Override
    public Optional<IngredientEntity> findOne(Integer ingredient_id) {
        return ingredientRepository.findById(ingredient_id);
    }

    @Override
    public List<IngredientEntity> findAll() {
        return StreamSupport.stream(ingredientRepository
                                .findAll()
                                .spliterator(),
                        false)
                .collect(Collectors.toList());
    }
}
