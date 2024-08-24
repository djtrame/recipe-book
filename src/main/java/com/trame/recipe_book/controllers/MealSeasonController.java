package com.trame.recipe_book.controllers;

import com.trame.recipe_book.entities.MealSeasonEntity;
import com.trame.recipe_book.services.MealSeasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MealSeasonController {
    private MealSeasonService mealSeasonService;

    public MealSeasonController(MealSeasonService mealSeasonService) {
        this.mealSeasonService = mealSeasonService;
    }

    @PostMapping(path = "/meal-seasons")
    public ResponseEntity<MealSeasonEntity> createSeason(@RequestBody MealSeasonEntity seasonEntity) {
        MealSeasonEntity savedSeasonEntity = mealSeasonService.save(seasonEntity);
        return new ResponseEntity<>(savedSeasonEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/meal-seasons/{id}")
    public ResponseEntity<MealSeasonEntity> getSeason(@PathVariable("id") Integer season_id) {
        Optional<MealSeasonEntity> foundMealSeason = mealSeasonService.findOne(season_id);

        if (foundMealSeason.isPresent()) {
            return new ResponseEntity<>(foundMealSeason.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/meal-seasons")
    public List<MealSeasonEntity> listSeasons() {
        List<MealSeasonEntity> mealSeasons = mealSeasonService.findAll();
        return mealSeasons;
    }
}
