package com.trame.recipe_book.services;

import com.trame.recipe_book.entities.SeasonEntity;

import java.util.List;
import java.util.Optional;

public interface SeasonService {
    SeasonEntity save(SeasonEntity seasonEntity);

    Optional<SeasonEntity> findOne(Integer season_id);

    List<SeasonEntity> findAll();

}
