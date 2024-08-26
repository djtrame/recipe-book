package com.trame.recipe_book.services.impl;

import com.trame.recipe_book.entities.*;
import com.trame.recipe_book.repositories.MealRepository;
import com.trame.recipe_book.services.MealService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MealServiceImpl implements MealService {

    private MealRepository mealRepository;

//    private MealSeasonRepository mealSeasonRepository;
//
//    public MealServiceImpl(MealRepository mealRepository, MealSeasonRepository mealSeasonRepository) {
//        this.mealRepository = mealRepository;
//        this.mealSeasonRepository = mealSeasonRepository;
//    }

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public MealEntity save(MealEntity mealEntity) {
        return mealRepository.save(mealEntity);
    }

    @Override
    public Optional<MealEntity> findOne(Integer meal_id) {
        return mealRepository.findById(meal_id);
    }

    @Override
    public List<MealEntity> findAll() {
        return StreamSupport.stream(mealRepository
                    .findAll()
                    .spliterator(),
                    false)
                .collect(Collectors.toList());
    }

    @Override
    public MealEntity linkMealToIngredient(MealEntity mealEntity, IngredientEntity ingredientEntity) {
        mealEntity.linkMealToIngredient(ingredientEntity);
        return mealRepository.save(mealEntity);
    }

    @Override
    public MealEntity linkMealToSeason(MealEntity mealEntity, SeasonEntity seasonEntity) {
        mealEntity.linkMealToSeason(seasonEntity);
        return mealRepository.save(mealEntity);
    }

    //@Override
//    public MealEntity linkMealToSeason_OLD(MealEntity mealEntity, SeasonEntity seasonEntity) {
//        LocalDateTime now = LocalDateTime.now();
//
//        String createSource = "SYSTEM"; //for now we don't want to add security context, so everything will just be system
//        String updateSource = "SYSTEM";
//
//        //this is an @Embeddable... maybe can't create on our own?
//        //MealSeasonId mealSeasonId = new MealSeasonId(mealEntity.getMeal_id(), seasonEntity.getSeason_id());
//
//        //MealSeasonEntity mealSeasonEntity = new MealSeasonEntity(mealSeasonId, mealEntity, seasonEntity, now, createSource, now, updateSource);
//
//        //trying empty constructor for a change, and just setting the meal and season on it
//        MealSeasonEntity mealSeasonEntity = new MealSeasonEntity();
//        mealSeasonEntity.setMeal(mealEntity);
//        mealSeasonEntity.setSeason(seasonEntity);
//
//        //mealEntity.linkMealToSeason(mealSeasonEntity);
//
//        //if this line runs we get this error: Cannot invoke "Object.getClass()" because "o" is null
//        //mealSeasonRepository.save(mealSeasonEntity);
//
//        return mealRepository.save(mealEntity);
//    }


}
