package com.trame.recipe_book.controllers;

import com.trame.recipe_book.entities.IngredientEntity;
import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.entities.SeasonEntity;
import com.trame.recipe_book.services.IngredientService;
import com.trame.recipe_book.services.MealService;
import com.trame.recipe_book.services.SeasonService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MealController {

    private MealService mealService;

    private IngredientService ingredientService;

    private SeasonService seasonService;

    public MealController(MealService mealService, IngredientService ingredientService, SeasonService seasonService) {
        this.mealService = mealService;
        this.ingredientService = ingredientService;
        this.seasonService = seasonService;
    }

    @PostMapping(path = "/meals")
    public ResponseEntity<MealEntity> createMeal(@RequestBody MealEntity mealEntity) {
        MealEntity savedMealEntity = mealService.save(mealEntity);
        return new ResponseEntity<>(savedMealEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/meals/{id}")
    public ResponseEntity<MealEntity> getMeal(@PathVariable("id") Integer meal_id) {
        Optional<MealEntity> foundMeal = mealService.findOne(meal_id);

        if (foundMeal.isPresent()) {
            return new ResponseEntity<>(foundMeal.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/meals")
    public List<MealEntity> listMeals() {
        List<MealEntity> meals = mealService.findAll();
        return meals;
    }

    //TODO add support for the junction table entity so we can get createdDate and createdSource fields
    @PutMapping(path = "/meals/{meal_id}/ingredients/{ingredient_id}")
    public ResponseEntity<MealEntity> linkMealToIngredient(
            @PathVariable Integer meal_id,
            @PathVariable Integer ingredient_id
    ) {
        Optional<MealEntity> foundMeal = mealService.findOne(meal_id);
        Optional<IngredientEntity> foundIngredient = ingredientService.findOne(ingredient_id);

        if (foundMeal.isPresent() && foundIngredient.isPresent()) {
            MealEntity returnMeal = mealService.linkMealToIngredient(foundMeal.get(), foundIngredient.get());
            return new ResponseEntity<>(returnMeal, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping(path = "/meals/{meal_id}/seasons/{season_id}")
    public ResponseEntity<MealEntity> linkMealToSeason(
            @PathVariable Integer meal_id,
            @PathVariable Integer season_id
    ) {
        Optional<MealEntity> foundMeal = mealService.findOne(meal_id);
        Optional<SeasonEntity> foundSeason = seasonService.findOne(season_id);

        if (foundMeal.isPresent() && foundSeason.isPresent()) {
            MealEntity returnMeal = mealService.linkMealToSeason(foundMeal.get(), foundSeason.get());
            return new ResponseEntity<>(returnMeal, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
