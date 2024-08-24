package com.trame.recipe_book.controllers;

import com.trame.recipe_book.entities.IngredientEntity;
import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.services.IngredientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IngredientController {

    private IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    @PostMapping(path = "/ingredients")
    public ResponseEntity<IngredientEntity> createIngredient(@RequestBody IngredientEntity ingredientEntity) {
        IngredientEntity savedIngredientEntity = ingredientService.save(ingredientEntity);
        return new ResponseEntity<>(savedIngredientEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/ingredients/{id}")
    public ResponseEntity<IngredientEntity> getIngredient(@PathVariable("id") Integer ingredient_id) {
        Optional<IngredientEntity> foundIngredient = ingredientService.findOne(ingredient_id);

        if (foundIngredient.isPresent()) {
            return new ResponseEntity<>(foundIngredient.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/ingredients")
    public List<IngredientEntity> listIngredients() {
        List<IngredientEntity> ingredients = ingredientService.findAll();
        return ingredients;
    }
}
