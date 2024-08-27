package com.trame.recipe_book.services.impl;

import com.trame.recipe_book.entities.MealEntity;
import com.trame.recipe_book.entities.MealSeasonEntity;
import com.trame.recipe_book.entities.SeasonEntity;
import com.trame.recipe_book.repositories.MealSeasonRepository;
import com.trame.recipe_book.services.MealSeasonService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MealSeasonServiceImpl implements MealSeasonService {

    private MealSeasonRepository mealSeasonRepository;

    public MealSeasonServiceImpl(MealSeasonRepository mealSeasonRepository) {
        this.mealSeasonRepository = mealSeasonRepository;
    }

    @Override
    public MealSeasonEntity save(MealSeasonEntity mealSeasonEntity) {
        return mealSeasonRepository.save(mealSeasonEntity);
    }

//    @Override
//    public Optional<MealSeasonEntity> findOne(Integer meal_id, Integer season_id) {
//        return Optional.empty();
//    }

    @Override
    public List<MealSeasonEntity> findAll() {
        return StreamSupport.stream(mealSeasonRepository
                    .findAll()
                    .spliterator(),
            false)
                .collect(Collectors.toList());
    }

    @Override
    public MealSeasonEntity linkMealToSeason(MealEntity mealEntity, SeasonEntity seasonEntity) {
        MealSeasonEntity mealSeasonEntity = new MealSeasonEntity(mealEntity, seasonEntity);
        return mealSeasonRepository.save(mealSeasonEntity);
    }


}
