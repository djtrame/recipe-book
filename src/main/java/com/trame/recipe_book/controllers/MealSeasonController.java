package com.trame.recipe_book.controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.trame.recipe_book.Utilities;
import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.entities.MealSeasonEntity;
import com.trame.recipe_book.entities.SeasonEntity;
import com.trame.recipe_book.services.MealSeasonService;
import com.trame.recipe_book.services.MealService;
import com.trame.recipe_book.services.SeasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MealSeasonController {
    private MealSeasonService mealSeasonService;
    private MealService mealService;
    private SeasonService seasonService;

    public MealSeasonController(MealSeasonService mealSeasonService, MealService mealService, SeasonService seasonService) {
        this.mealSeasonService = mealSeasonService;
        this.mealService = mealService;
        this.seasonService = seasonService;
    }

    @PostMapping(path = "/meal-seasons")
    public ResponseEntity<MealSeasonEntity> createMealSeason(@RequestBody MealSeasonEntity mealSeasonEntity) {
        MealSeasonEntity savedMealSeasonEntity = mealSeasonService.save(mealSeasonEntity);
        return new ResponseEntity<>(savedMealSeasonEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/hello")
    public String helloWorld() {
//        String currentUser = Utilities.getCurrentUsername();
//        return "Hello " + currentUser + "!";
        return "Hello djtrame!";
    }

//    @GetMapping(path = "/current-user")
//    public String currentUser(@AuthenticationPrincipal UserDetails userDetails) {
//        return userDetails.getUsername();
//    }

    @PostMapping("/echo")
    public ResponseEntity<String> echoJson(@RequestBody String json) {
        return ResponseEntity.ok(json);
    }

//    @GetMapping(path = "/meal-seasons/{id}")
//    public ResponseEntity<MealSeasonEntity> getSeason(@PathVariable("id") Integer season_id) {
//        Optional<MealSeasonEntity> foundMealSeason = mealSeasonService.findOne(season_id);
//
//        if (foundMealSeason.isPresent()) {
//            return new ResponseEntity<>(foundMealSeason.get(), HttpStatus.OK);
//        }
//        else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

    @GetMapping(path = "/meal-seasons")
    public List<MealSeasonEntity> listSeasons() {
        List<MealSeasonEntity> mealSeasons = mealSeasonService.findAll();
        return mealSeasons;
    }

    @PutMapping(path = "/meal-seasons/{meal_id}/{season_id}")
    public ResponseEntity<MealSeasonEntity> linkMealToSeason(
            @PathVariable Integer meal_id,
            @PathVariable Integer season_id
    ) {
        Optional<MealEntity> foundMeal = mealService.findOne(meal_id);
        Optional<SeasonEntity> foundSeason = seasonService.findOne(season_id);

        if (foundMeal.isPresent() && foundSeason.isPresent()) {
            MealSeasonEntity returnMeal = mealSeasonService.linkMealToSeason(foundMeal.get(), foundSeason.get());
            return new ResponseEntity<>(returnMeal, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
