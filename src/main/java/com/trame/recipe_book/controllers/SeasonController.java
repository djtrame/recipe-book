package com.trame.recipe_book.controllers;

import com.trame.recipe_book.entities.SeasonEntity;
import com.trame.recipe_book.services.IngredientService;
import com.trame.recipe_book.services.SeasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SeasonController {

    private SeasonService seasonService;

    public SeasonController(SeasonService seasonService, IngredientService ingredientService) {
        this.seasonService = seasonService;
    }

    @PostMapping(path = "/seasons")
    public ResponseEntity<SeasonEntity> createSeason(@RequestBody SeasonEntity seasonEntity) {
        SeasonEntity savedSeasonEntity = seasonService.save(seasonEntity);
        return new ResponseEntity<>(savedSeasonEntity, HttpStatus.CREATED);
    }

    @GetMapping(path = "/seasons/{id}")
    public ResponseEntity<SeasonEntity> getSeason(@PathVariable("id") Integer season_id) {
        Optional<SeasonEntity> foundSeason = seasonService.findOne(season_id);

        if (foundSeason.isPresent()) {
            return new ResponseEntity<>(foundSeason.get(), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(path = "/seasons")
    public List<SeasonEntity> listSeasons() {
        List<SeasonEntity> seasons = seasonService.findAll();
        return seasons;
    }



}
