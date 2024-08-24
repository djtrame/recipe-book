package com.trame.recipe_book.controllers;

import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.services.MealService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MealController {

    private MealService mealService;

    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @PostMapping(path = "/meals")
    public ResponseEntity<MealEntity> createMeal(@RequestBody MealEntity mealEntity) {
        MealEntity savedMealEntity = mealService.save(mealEntity);
        return new ResponseEntity<>(savedMealEntity, HttpStatus.CREATED);
    }
}
